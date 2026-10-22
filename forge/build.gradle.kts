plugins {
    id("com.alkeari.modtrix.forge")
}

// Plain content filters rather than exclusiveContent: exclusiveContent edits every other repository, and ForgeGradle 7
// refuses changes to its Mavenizer repository once it has been read.
repositories {
    maven("https://maven.ftb.dev/releases") { content { includeGroup("dev.ftb.mods") } }
    maven("https://maven.architectury.dev/") { content { includeGroup("dev.architectury") } }
    maven("https://maven.shedaniel.me/") { content { includeGroupAndSubgroups("me.shedaniel") } }
}

// ModDevGradle's legacy mode (1.20.1) remaps mod jars through modImplementation; ForgeGradle 7 has no such
// configuration, and these mods are only compiled against there, since they ship in the player's mods folder.
val modConfiguration = if (configurations.findByName("modImplementation") != null) "modImplementation" else "compileOnly"

dependencies {
    for (notation in listOf(
        "dev.ftb.mods:ftb-ultimine-forge:${modtrix.dep("ftb_ultimine")}",
        "dev.ftb.mods:ftb-library-forge:${modtrix.dep("ftb_library")}",
        "dev.architectury:architectury-forge:${modtrix.dep("architectury")}",
    )) {
        (add(modConfiguration, notation) as ExternalModuleDependency).isTransitive = false
    }
}
