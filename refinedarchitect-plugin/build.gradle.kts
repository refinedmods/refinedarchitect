plugins {
    `kotlin-dsl`
    `maven-publish`
}

base {
    archivesName.set("refinedarchitect-plugin")
}

tasks.publish {
    dependsOn("check")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        name = "NeoForge"
        url = project.uri("https://maven.neoforged.net/releases")
    }
    maven {
        name = "Fabric"
        url = project.uri("https://maven.fabricmc.net/")
    }
}

dependencies {
    implementation("net.neoforged:moddev-gradle:2.0.27-beta")
    implementation("fabric-loom:fabric-loom.gradle.plugin:1.8.0-alpha.9")
    implementation("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext:gradle-idea-ext:1.1.8")
    implementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.15.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.4.1.3373")
    implementation("net.darkhax.curseforgegradle:CurseForgeGradle:1.1.18")
    implementation("com.modrinth.minotaur:Minotaur:2.8.7")
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
        mavenLocal()
    }
}
