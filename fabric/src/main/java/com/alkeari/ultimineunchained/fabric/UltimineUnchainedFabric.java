package com.alkeari.ultimineunchained.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import com.alkeari.ultimineunchained.UltimineUnchained;
import net.fabricmc.api.ModInitializer;

public class UltimineUnchainedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(UltimineUnchainedConfig.class, GsonConfigSerializer::new);
        UltimineUnchained.init();
    }
}
