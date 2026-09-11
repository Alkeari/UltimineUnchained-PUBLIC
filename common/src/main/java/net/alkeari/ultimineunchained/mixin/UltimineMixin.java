package net.alkeari.ultimineunchained.mixin;

import dev.architectury.event.EventResult;
import dev.architectury.utils.value.IntValue;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.alkeari.ultimineunchained.config.ModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DigDurabilityEnchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FTBUltimine.class, remap = false)
public class UltimineMixin {

    // Tracks call depth so inner destroyBlock() re-entries don't clobber the outer snapshot.
    private static int breakingDepth = 0;
    private static int toolDamageSnapshot = 0;
    // Counts blocks the tool can mine in the current ultimine operation (excluding the trigger).
    private static int blocksBroken = 0;
    // Set to true when FTBUltimine processes inner blocks. Used instead of inspecting the outer
    // EventResult, which can change to pass() when cancelled blocks are present, causing the
    // durability application to be incorrectly skipped.
    private static boolean ultimineDidRun = false;

    @Inject(method = "blockBroken", at = @At("HEAD"))
    private void onBlockBrokenHead(
            Level world, BlockPos pos, BlockState state, ServerPlayer player,
            IntValue xp, CallbackInfoReturnable<EventResult> cir) {
        breakingDepth++;
        if (!player.isCreative()) {
            if (breakingDepth == 1) {
                toolDamageSnapshot = player.getMainHandItem().getDamageValue();
                blocksBroken = 0;
                ultimineDidRun = false;
            } else {
                ultimineDidRun = true;
                // Only count blocks the tool can mine and receive drops from.
                ItemStack stack = player.getMainHandItem();
                if (!state.requiresCorrectToolForDrops() || stack.isCorrectToolForDrops(state)) {
                    blocksBroken++;
                }
            }
        }
    }

    // Sets baseSpeed to MAX_VALUE so "destroySpeed > baseSpeed" is never true for normal blocks.
    // ordinal=0 targets the first float local in blockBroken (baseSpeed).
    @ModifyVariable(method = "blockBroken", at = @At(value = "STORE"), ordinal = 0)
    private float modifyBaseSpeed(float original) {
        return ModConfig.getAllowHarderBlocks() ? Float.MAX_VALUE : original;
    }

    @Inject(method = "blockBroken", at = @At("RETURN"), cancellable = true)
    private void onBlockBrokenReturn(
            Level world, BlockPos pos, BlockState state, ServerPlayer player,
            IntValue xp, CallbackInfoReturnable<EventResult> cir) {
        breakingDepth--;
        if (breakingDepth != 0) {
            // Inner call - cancel the break for blocks the tool can't mine for drops.
            // interruptFalse() causes Architectury to cancel the underlying BreakEvent
            // so the block is never removed from the world.
            if (!player.isCreative()) {
                ItemStack stack = player.getMainHandItem();
                if (state.requiresCorrectToolForDrops() && !stack.isCorrectToolForDrops(state)) {
                    cir.setReturnValue(EventResult.interruptFalse());
                    cir.cancel();
                }
            }
            return;
        }

        // Outer call - apply configured durability cost for this ultimine operation.
        if (!ultimineDidRun) return;
        if (player.isCreative()) return;

        ItemStack stack = player.getMainHandItem();
        if (!stack.isEmpty() && stack.isDamageableItem()) {
            double percentage = ModConfig.getDurabilityPercentage();
            int damageToApply = (percentage > 0.0)
                    ? (int) Math.round(blocksBroken * percentage)
                    : ModConfig.getDurabilityFlatBlocks();

            // Respect Unbreaking: roll the enchantment's chance for each point of damage.
            int unbreakingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, stack);
            int actualDamage = 0;
            for (int i = 0; i < damageToApply; i++) {
                if (!DigDurabilityEnchantment.shouldIgnoreDurabilityDrop(stack, unbreakingLevel, player.getRandom())) {
                    actualDamage++;
                }
            }

            int target = toolDamageSnapshot + actualDamage;
            stack.setDamageValue(Math.max(0, Math.min(target, stack.getMaxDamage() - 1)));
        }
    }
}
