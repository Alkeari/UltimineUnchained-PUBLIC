package net.alkeari.ultimineunchained.forge;

import dev.architectury.platform.forge.EventBuses;
import net.alkeari.ultimineunchained.UltimineUnchained;
import net.alkeari.ultimineunchained.config.forge.ModConfigImpl;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UltimineUnchained.MOD_ID)
public class UltimineUnchainedForge {
    @SuppressWarnings("removal")
    public UltimineUnchainedForge() {
        EventBuses.registerModEventBus(UltimineUnchained.MOD_ID,
                FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModConfigImpl.SPEC);
        UltimineUnchained.init();
    }
}
