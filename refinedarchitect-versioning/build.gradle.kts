plugins {
    `version-catalog`
    `maven-publish`
}

catalog {
    versionCatalog {
        // https://launchermeta.mojang.com/mc/game/version_manifest_v2.json
        val slf4j = version("slf4j", "2.0.9")
        library("slf4j-api", "org.slf4j", "slf4j-api").versionRef(slf4j)
        library("slf4j-impl", "org.slf4j", "slf4j-simple").versionRef(slf4j)

        val apiGuardian = version("apiGuardian", "1.1.2")
        library("apiguardian", "org.apiguardian", "apiguardian-api").versionRef(apiGuardian)

        val junit5 = version("junit5", "5.10.3")
        library("junit-api", "org.junit.jupiter", "junit-jupiter-api").versionRef(junit5)
        library("junit-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef(junit5)
        library("junit-params", "org.junit.jupiter", "junit-jupiter-params").versionRef(junit5)

        val assertJ = version("assertJ", "3.26.0")
        library("assertj", "org.assertj", "assertj-core").versionRef(assertJ)

        val mockito = version("mockito", "5.12.0")
        library("mockito", "org.mockito", "mockito-core").versionRef(mockito)

        val equalsVerifier = version("equalsverifier", "3.16.1")
        library("equalsverifier", "nl.jqno.equalsverifier", "equalsverifier").versionRef(equalsVerifier)

        // https://www.curseforge.com/minecraft/mc-mods/cloth-config/files
        val clothConfig = version("cloth-config-fabric", "15.0.127")
        library("cloth-config", "me.shedaniel.cloth", "cloth-config-fabric").versionRef(clothConfig)

        // https://github.com/TechReborn/Energy (https://maven.fabricmc.net/teamreborn/energy/)
        val energy = version("teamreborn-energy", "4.1.0")
        library("teamreborn-energy", "teamreborn", "energy").versionRef(energy)

        // https://modrinth.com/mod/modmenu
        val modmenu = version("modmenu", "11.0.1")
        library("modmenu", "com.terraformersmc", "modmenu").versionRef(modmenu)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}