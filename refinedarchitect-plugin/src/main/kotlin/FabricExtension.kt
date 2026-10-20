import net.fabricmc.loom.api.LoomGradleExtensionAPI
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources

open class FabricExtension(private val project: Project) : BaseExtension(project) {
    var modId: String? = null

    fun fabric() {
        project.configurations["commonJava"].isCanBeResolved = true
        project.configurations["commonJava"].isCanBeConsumed = modId == null
        project.configurations["commonResources"].isCanBeResolved = true
        project.configurations["commonResources"].isCanBeConsumed = modId == null

        project.dependencies.add("minecraft", "com.mojang:minecraft:${mcVersion}")
        project.dependencies.add("implementation", "net.fabricmc:fabric-loader:${fabricLoaderVersion}")
        project.dependencies.add("implementation", "net.fabricmc.fabric-api:fabric-api:${fabricApiVersion}")

        if (modId != null) {
            project.extensions.getByType<LoomGradleExtensionAPI>().apply {
                val accessWidenerFile = project.file("src/main/resources/${modId!!}.accesswidener")
                if (accessWidenerFile.exists()) {
                    accessWidenerPath.set(accessWidenerFile)
                }
                runs {
                    getByName("client") {
                        client()
                        setConfigName("Fabric Client")
                        ideConfigGenerated(true)
                        runDir("run")
                    }
                    getByName("server") {
                        server()
                        setConfigName("Fabric Server")
                        ideConfigGenerated(true)
                        runDir("run")
                    }
                }
                mixin {
                    showMessageTypes.set(true)
                    messages.put("TARGET_ELEMENT_NOT_FOUND", "disabled")
                }
            }
        }
        project.tasks.named("compileJava", JavaCompile::class.java) {
            dependsOn(project.configurations["commonJava"])
            source(project.configurations["commonJava"])
        }
        project.tasks.named("processResources", ProcessResources::class.java) {
            val properties = mapOf("version" to project.version)
            inputs.properties(properties)
            filesMatching(listOf("fabric.mod.json")) {
                expand(properties)
            }
            dependsOn(project.configurations["commonResources"])
            from(project.configurations["commonResources"])
        }
        project.tasks.withType<Jar>().configureEach {
            from("../LICENSE.md")
        }
    }

    fun gameTests() {
        val sourceSets = project.extensions.getByType<JavaPluginExtension>().sourceSets
        project.extensions.getByType<LoomGradleExtensionAPI>().apply {
            runs.create("gameTest") {
                server()
                setConfigName("Fabric Game Test")
                ideConfigGenerated(true)
                runDir("run")
                source(sourceSets["test"])
                property("fabric-api.gametest", "true")
                property(
                    "fabric-api.gametest.report-file",
                    project.layout.buildDirectory.file("reports/gametest/gametest.xml").get().asFile.absolutePath
                )
            }
        }
        // The test source set in this subproject is used for Minecraft game tests, not for JUnit tests.
        project.tasks.getByName("test").onlyIf { false }
    }
}
