package net.alkeari.ultimineunchained.config.forge;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigImpl {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.DoubleValue DURABILITY_PERCENTAGE;
    private static final ForgeConfigSpec.IntValue DURABILITY_FLAT_BLOCKS;
    private static final ForgeConfigSpec.BooleanValue ALLOW_HARDER_BLOCKS;
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("ultimine_unchained");

        DURABILITY_PERCENTAGE = BUILDER
                .comment("Fraction of blocks broken that counts toward tool durability (0.0 to 1.0).",
                         "Example: 0.5 with 64 blocks broken = 32 blocks worth of durability damage.",
                         "Set to 0.0 to use durability_flat_blocks instead.")
                .defineInRange("durability_percentage", 0.0, 0.0, 1.0);

        DURABILITY_FLAT_BLOCKS = BUILDER
                .comment("Flat durability cost per ultimine operation, in block-break equivalents.",
                         "Used only when durability_percentage is 0.0.",
                         "Default of 1 means the entire operation costs the same as breaking a single block.")
                .defineInRange("durability_flat_blocks", 1, 0, 32768);

        ALLOW_HARDER_BLOCKS = BUILDER
                .comment("When true, suppresses the check that skips blocks harder than the first targeted block.",
                         "Indestructible blocks (destroy speed < 0) are still always skipped.")
                .define("allow_harder_blocks", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static double getDurabilityPercentage() {
        return DURABILITY_PERCENTAGE.get();
    }

    public static int getDurabilityFlatBlocks() {
        return DURABILITY_FLAT_BLOCKS.get();
    }

    public static boolean getAllowHarderBlocks() {
        return ALLOW_HARDER_BLOCKS.get();
    }
}
