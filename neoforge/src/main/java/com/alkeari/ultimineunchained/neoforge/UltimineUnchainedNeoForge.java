package com.alkeari.ultimineunchained.neoforge;

import com.alkeari.ultimineunchained.UltimineUnchained;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
//? if <1.20.5
/*import net.neoforged.fml.ModLoadingContext;*/

@Mod(UltimineUnchained.MOD_ID)
public class UltimineUnchainedNeoForge {
    public UltimineUnchainedNeoForge(IEventBus modBus, ModContainer modContainer) {
        // ModContainer.registerConfig arrived with NeoForge 20.5; earlier builds register through ModLoadingContext.
        //? if >=1.20.5 {
        modContainer.registerConfig(ModConfig.Type.SERVER, NeoForgeConfigSource.SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfigSource.COMMON_SPEC);
        //?} else {
        /*ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, NeoForgeConfigSource.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NeoForgeConfigSource.COMMON_SPEC);
        *///?}
        UltimineUnchained.init();
    }
}
