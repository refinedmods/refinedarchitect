plugins {
    `version-catalog`
    `maven-publish`
}

catalog {
    versionCatalog {
        // See: https://launchermeta.mojang.com/mc/game/version_manifest_v2.json
        val slf4j = version("slf4j", "2.0.9")
        library("slf4j-api", "org.slf4j", "slf4j-api").versionRef(slf4j)
        library("slf4j-impl", "org.slf4j", "slf4j-simple").versionRef(slf4j)

        // See: https://mvnrepository.com/artifact/org.apiguardian/apiguardian-api
        val apiGuardian = version("apiGuardian", "1.1.2")
        library("apiguardian", "org.apiguardian", "apiguardian-api").versionRef(apiGuardian)

        // See: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
        val junit5 = version("junit5", "5.11.4")
        library("junit-api", "org.junit.jupiter", "junit-jupiter-api").versionRef(junit5)
        library("junit-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef(junit5)
        library("junit-params", "org.junit.jupiter", "junit-jupiter-params").versionRef(junit5)

        // See: https://mvnrepository.com/artifact/org.assertj/assertj-core
        val assertJ = version("assertJ", "3.27.3")
        library("assertj", "org.assertj", "assertj-core").versionRef(assertJ)

        // See: https://mvnrepository.com/artifact/org.mockito/mockito-core
        val mockito = version("mockito", "5.15.2")
        library("mockito", "org.mockito", "mockito-core").versionRef(mockito)

        // See: https://mvnrepository.com/artifact/nl.jqno.equalsverifier/equalsverifier
        val equalsVerifier = version("equalsverifier", "3.18.1")
        library("equalsverifier", "nl.jqno.equalsverifier", "equalsverifier").versionRef(equalsVerifier)

        // See: https://www.curseforge.com/minecraft/mc-mods/cloth-config/files
        val clothConfig = version("cloth-config-fabric", "15.0.140")
        library("cloth-config", "me.shedaniel.cloth", "cloth-config-fabric").versionRef(clothConfig)

        // See: https://github.com/TechReborn/Energy (https://maven.fabricmc.net/teamreborn/energy/)
        val energy = version("teamreborn-energy", "4.1.0")
        library("teamreborn-energy", "teamreborn", "energy").versionRef(energy)

        // See: https://modrinth.com/mod/modmenu
        val modmenu = version("modmenu", "11.0.3")
        library("modmenu", "com.terraformersmc", "modmenu").versionRef(modmenu)
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = project.uri("https://maven.pkg.github.com/" + System.getenv("GITHUB_REPOSITORY"))
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}