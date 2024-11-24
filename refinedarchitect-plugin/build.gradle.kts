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
    implementation("net.neoforged:moddev-gradle:2.0.47-beta")
    implementation("fabric-loom:fabric-loom.gradle.plugin:1.8.12")
    implementation("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext:gradle-idea-ext:1.1.8")
    implementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.15.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.4.1.3373")
    implementation("me.modmuss50:mod-publish-plugin:0.8.0")
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
}
