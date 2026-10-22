package com.alkeari.ultimineunchained.forge;

import com.alkeari.ultimineunchained.UltimineUnchained;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(UltimineUnchained.MOD_ID)
public class UltimineUnchainedForge {
    // ModLoadingContext.registerConfig exists from Forge 47.1, which the NeoForge 1.20.1 fork also provides.
    @SuppressWarnings("removal")
    public UltimineUnchainedForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ForgeConfigSource.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ForgeConfigSource.COMMON_SPEC);
        UltimineUnchained.init();
    }
}
