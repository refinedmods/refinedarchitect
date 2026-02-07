plugins {
    id("com.refinedmods.refinedarchitect")
    id("net.neoforged.moddev")
}

project.extensions.create("refinedarchitect", NeoForgeExtension::class, project)
