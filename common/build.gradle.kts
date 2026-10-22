plugins {
    id("com.alkeari.modtrix.common")
}

repositories {
    exclusiveContent {
        forRepository { maven("https://maven.ftb.dev/releases") }
        filter { includeGroup("dev.ftb.mods") }
    }
    exclusiveContent {
        forRepository { maven("https://maven.architectury.dev/") }
        filter { includeGroup("dev.architectury") }
    }
    exclusiveContent {
        forRepository { maven("https://maven.shedaniel.me/") }
        filter { includeGroupAndSubgroups("me.shedaniel") }
    }
}

dependencies {
    // FTB Ultimine's blockBroken signature uses Architectury types; FTB Ultimine brings both at runtime.
    modCompileOnly("dev.ftb.mods:ftb-ultimine-fabric:${modtrix.dep("ftb_ultimine")}") { isTransitive = false }
    // Loom remaps mods once per project tree, so Fabric API must be on this classpath too or Architectury's overrides of its interfaces keep intermediary names.
    modCompileOnly("dev.architectury:architectury-fabric:${modtrix.dep("architectury")}") { isTransitive = false }
    modCompileOnly("net.fabricmc.fabric-api:fabric-api:${modtrix.dep("fabric_api")}")
}
