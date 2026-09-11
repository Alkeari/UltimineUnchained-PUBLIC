package net.alkeari.ultimineunchained.config;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class ModConfig {
    @ExpectPlatform
    public static double getDurabilityPercentage() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static int getDurabilityFlatBlocks() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean getAllowHarderBlocks() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static int getDurabilityCapPercent() {
        throw new AssertionError();
    }
}
