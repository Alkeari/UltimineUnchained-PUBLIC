package com.alkeari.ultimineunchained.config;

import java.util.ServiceLoader;

public final class ModConfig {
    private static final ConfigSource SOURCE = ServiceLoader.load(ConfigSource.class, ModConfig.class.getClassLoader())
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("No " + ConfigSource.class.getName() + " registered for this loader"));

    private ModConfig() {
    }

    public static double getDurabilityPercentage() {
        return SOURCE.durabilityPercentage();
    }

    public static int getDurabilityFlatBlocks() {
        return SOURCE.durabilityFlatBlocks();
    }

    public static boolean getAllowHarderBlocks() {
        return SOURCE.allowHarderBlocks();
    }

    public static int getDurabilityCapPercent() {
        return SOURCE.durabilityCapPercent();
    }

    public static boolean getCheckForUpdates() {
        return SOURCE.checkForUpdates();
    }
}
