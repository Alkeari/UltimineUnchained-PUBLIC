package com.alkeari.ultimineunchained.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import com.alkeari.ultimineunchained.config.ConfigSource;

public class FabricConfigSource implements ConfigSource {
    private static UltimineUnchainedConfig get() {
        return AutoConfig.getConfigHolder(UltimineUnchainedConfig.class).getConfig();
    }

    @Override
    public double durabilityPercentage() {
        return get().durabilityPercentage / 100.0;
    }

    @Override
    public int durabilityFlatBlocks() {
        return get().durabilityFlatBlocks;
    }

    @Override
    public boolean allowHarderBlocks() {
        return get().allowHarderBlocks;
    }

    @Override
    public int durabilityCapPercent() {
        return get().durabilityCapPercent;
    }

    @Override
    public boolean checkForUpdates() {
        return get().checkForUpdates;
    }
}
