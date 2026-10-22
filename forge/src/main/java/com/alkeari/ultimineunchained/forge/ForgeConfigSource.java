package com.alkeari.ultimineunchained.forge;

import com.alkeari.ultimineunchained.config.ConfigSource;
import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfigSource implements ConfigSource {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.DoubleValue DURABILITY_PERCENTAGE;
    private static final ForgeConfigSpec.IntValue DURABILITY_FLAT_BLOCKS;
    private static final ForgeConfigSpec.BooleanValue ALLOW_HARDER_BLOCKS;
    private static final ForgeConfigSpec.IntValue DURABILITY_CAP_PERCENT;
    public static final ForgeConfigSpec SPEC;
    private static final ForgeConfigSpec.BooleanValue CHECK_FOR_UPDATES;
    public static final ForgeConfigSpec COMMON_SPEC;

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

        DURABILITY_CAP_PERCENT = BUILDER
                .comment("Maximum percentage of max durability that can be consumed per ultimine operation (0 to 100).",
                         "Example: 25 with a tool of max durability 2000 caps consumption at 500 damage per operation.")
                .defineInRange("durability_cap_percent", 25, 0, 100);

        BUILDER.pop();
        SPEC = BUILDER.build();

        // The update check runs before any world is loaded, so it lives in the common file rather than the per-world one.
        ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();
        common.push("updates");
        CHECK_FOR_UPDATES = common
                .comment("Once per game start, check https://alkeari.com/updates/ultimine-unchained.json and say so only when a newer version is out.")
                .define("check_for_updates", true);
        common.pop();
        COMMON_SPEC = common.build();
    }

    @Override
    public double durabilityPercentage() {
        return DURABILITY_PERCENTAGE.get();
    }

    @Override
    public int durabilityFlatBlocks() {
        return DURABILITY_FLAT_BLOCKS.get();
    }

    @Override
    public boolean allowHarderBlocks() {
        return ALLOW_HARDER_BLOCKS.get();
    }

    @Override
    public int durabilityCapPercent() {
        return DURABILITY_CAP_PERCENT.get();
    }

    @Override
    public boolean checkForUpdates() {
        return CHECK_FOR_UPDATES.get();
    }
}
