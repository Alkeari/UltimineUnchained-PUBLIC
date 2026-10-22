plugins {
    id("com.alkeari.modtrix.fabric")
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
    modImplementation("me.shedaniel.cloth:cloth-config-fabric:${modtrix.dep("cloth_config")}") {
        exclude(group = "net.fabricmc.fabric-api")
    }
    modImplementation("dev.ftb.mods:ftb-ultimine-fabric:${modtrix.dep("ftb_ultimine")}") { isTransitive = false }
    modImplementation("dev.ftb.mods:ftb-library-fabric:${modtrix.dep("ftb_library")}") { isTransitive = false }
    modImplementation("dev.architectury:architectury-fabric:${modtrix.dep("architectury")}") { isTransitive = false }
}
