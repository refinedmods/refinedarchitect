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
        url = uri("https://maven.neoforged.net/releases")
    }
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
}

dependencies {
    // See: https://projects.neoforged.net/neoforged/ModDevGradle
    implementation("net.neoforged:moddev-gradle:2.0.141")
    // See: https://mvnrepository.com/artifact/fabric-loom/fabric-loom.gradle.plugin/versions?repo=modmuss50
    implementation("fabric-loom:fabric-loom.gradle.plugin:1.17.0-alpha.7")
    // See: https://github.com/neoforged/ModDevGradle/blob/main/build.gradle
    implementation("gradle.plugin.org.jetbrains.gradle.plugin.idea-ext:gradle-idea-ext:1.2")
    // https://mvnrepository.com/artifact/info.solidsoft.gradle.pitest/gradle-pitest-plugin/versions?repo=gradle-plugins
    implementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.19.0-rc.2")
    // https://mvnrepository.com/artifact/org.sonarqube/org.sonarqube.gradle.plugin
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:7.2.2.6593")
    // See: https://modmuss50.github.io/mod-publish-plugin/getting_started/
    implementation("me.modmuss50:mod-publish-plugin:2.1.1")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/" + System.getenv("GITHUB_REPOSITORY"))
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            name = "CreeperHost"
            url = uri("https://maven.creeperhost.net/release")
            credentials {
                username = System.getenv("CREEPERHOST_MAVEN_USERNAME")
                password = System.getenv("CREEPERHOST_MAVEN_TOKEN")
            }
        }
    }
}
