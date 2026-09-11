package net.alkeari.ultimineunchained.config.fabric;

import net.alkeari.ultimineunchained.fabric.UltimineUnchainedConfig;

import me.shedaniel.autoconfig.AutoConfig;

public class ModConfigImpl {
    private static UltimineUnchainedConfig get() {
        return AutoConfig.getConfigHolder(UltimineUnchainedConfig.class).getConfig();
    }

    public static double getDurabilityPercentage() {
        return get().durabilityPercentage / 100.0;
    }

    public static int getDurabilityFlatBlocks() {
        return get().durabilityFlatBlocks;
    }

    public static boolean getAllowHarderBlocks() {
        return get().allowHarderBlocks;
    }

    public static int getDurabilityCapPercent() {
        return get().durabilityCapPercent;
    }
}
