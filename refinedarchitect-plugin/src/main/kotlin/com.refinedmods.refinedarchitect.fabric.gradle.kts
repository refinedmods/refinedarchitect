plugins {
    id("com.refinedmods.refinedarchitect")
    id("fabric-loom")
}

repositories {
    maven {
        name = "ParchmentMC"
        url = project.uri("https://maven.parchmentmc.org")
    }
}

project.extensions.create("refinedarchitect", FabricExtension::class, project)
