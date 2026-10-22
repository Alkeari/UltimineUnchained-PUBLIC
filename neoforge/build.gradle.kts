plugins {
    id("com.alkeari.modtrix.neoforge")
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
    implementation("dev.ftb.mods:ftb-ultimine-neoforge:${modtrix.dep("ftb_ultimine")}") { isTransitive = false }
    implementation("dev.ftb.mods:ftb-library-neoforge:${modtrix.dep("ftb_library")}") { isTransitive = false }
    implementation("dev.architectury:architectury-neoforge:${modtrix.dep("architectury")}") { isTransitive = false }
}
