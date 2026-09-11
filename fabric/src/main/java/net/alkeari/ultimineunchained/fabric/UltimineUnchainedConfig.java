package net.alkeari.ultimineunchained.fabric;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "ultimineunchained")
public class UltimineUnchainedConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean allowHarderBlocks = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public int durabilityPercentage = 0;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 32768)
    public int durabilityFlatBlocks = 1;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public int durabilityCapPercent = 25;

    @Override
    public void validatePostLoad() throws ValidationException {
        durabilityPercentage = Math.max(0, Math.min(100, durabilityPercentage));
        durabilityFlatBlocks = Math.max(0, Math.min(32768, durabilityFlatBlocks));
        durabilityCapPercent = Math.max(0, Math.min(100, durabilityCapPercent));
    }
}
