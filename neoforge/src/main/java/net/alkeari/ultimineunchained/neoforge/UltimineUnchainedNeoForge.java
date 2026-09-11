package net.alkeari.ultimineunchained.neoforge;

import net.alkeari.ultimineunchained.UltimineUnchained;
import net.alkeari.ultimineunchained.config.neoforge.ModConfigImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(UltimineUnchained.MOD_ID)
public class UltimineUnchainedNeoForge {
    public UltimineUnchainedNeoForge(IEventBus modBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, ModConfigImpl.SPEC);
        UltimineUnchained.init();
    }
}
