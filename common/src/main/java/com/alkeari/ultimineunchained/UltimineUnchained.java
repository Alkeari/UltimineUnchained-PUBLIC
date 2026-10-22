package com.alkeari.ultimineunchained;

import com.alkeari.modtrix.api.Events;
import com.alkeari.modtrix.api.Updates;
import com.alkeari.ultimineunchained.config.ModConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltimineUnchained {
    public static final String MOD_ID = "ultimineunchained";
    public static final Logger LOGGER = LoggerFactory.getLogger("UltimineUnchained");
    public static final String UPDATE_URL = "https://alkeari.com/updates/ultimine-unchained.json";
    private static final AtomicBoolean UPDATE_CHECK_DECIDED = new AtomicBoolean();

    public static void init() {
        LOGGER.info("Ultimine Unchained loaded.");
        // Forge and NeoForge load the settings file after the mod is constructed, so the setting is read on the first tick.
        Runnable decide = () -> {
            if (UPDATE_CHECK_DECIDED.compareAndSet(false, true) && ModConfig.getCheckForUpdates()) {
                Updates.check(MOD_ID, UPDATE_URL);
            }
        };
        Events.onClientTick(decide);
        Events.onServerTick(server -> decide.run());
    }
}
