package com.alkeari.ultimineunchained.config;

/** Each loader supplies one implementation through META-INF/services. */
public interface ConfigSource {
    /** Fraction of blocks broken that counts toward durability, 0.0 to 1.0. */
    double durabilityPercentage();

    int durabilityFlatBlocks();

    boolean allowHarderBlocks();

    int durabilityCapPercent();

    boolean checkForUpdates();
}
