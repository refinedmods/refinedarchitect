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
    // See: https://projects.neoforged.net/neoforged/ModDevGradle
    implementation("net.neoforged:moddev-gradle:2.0.107")
    // See: https://mvnrepository.com/artifact/fabric-loom/fabric-loom.gradle.plugin
    implementation("fabric-loom:fabric-loom.gradle.plugin:1.11.4")
    // See: https://github.com/neoforged/ModDevGradle/blob/main/build.gradle
    implementation("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext:gradle-idea-ext:1.2")
    implementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.15.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.4.1.3373")
    // See: https://modmuss50.github.io/mod-publish-plugin/getting_started/
    implementation("me.modmuss50:mod-publish-plugin:0.8.4")
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
        maven {
            name = "CreeperHost"
            url = project.uri("https://maven.creeperhost.net/release")
            credentials {
                username = System.getenv("CREEPERHOST_MAVEN_USERNAME")
                password = System.getenv("CREEPERHOST_MAVEN_TOKEN")
            }
        }
    }
}
