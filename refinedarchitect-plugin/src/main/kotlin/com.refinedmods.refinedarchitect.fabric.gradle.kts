plugins {
    id("com.refinedmods.refinedarchitect")
    id("net.fabricmc.fabric-loom")
}

project.extensions.create("refinedarchitect", FabricExtension::class, project)
