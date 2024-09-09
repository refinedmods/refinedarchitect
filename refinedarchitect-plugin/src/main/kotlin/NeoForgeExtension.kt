import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources
import net.neoforged.moddevgradle.dsl.NeoForgeExtension as NfExtension

open class NeoForgeExtension(private val project: Project) : BaseExtension(project) {
    var modId: String? = null

    fun neoForge() {
        val sourceSets = project.extensions.getByType<JavaPluginExtension>().sourceSets
        project.configurations["commonJava"].isCanBeResolved = true
        project.configurations["commonJava"].isCanBeConsumed = modId == null
        project.configurations["commonResources"].isCanBeResolved = true
        project.configurations["commonResources"].isCanBeConsumed = modId == null
        project.extensions.getByType<NfExtension>().apply {
            version.set(neoForgeVersion)
            addModdingDependenciesTo(sourceSets["test"])
            if (modId != null) {
                mods {
                    register(modId!!) {
                        modSourceSets.set(listOf(sourceSets["main"], sourceSets["test"]))
                    }
                }
                runs {
                    register("client") {
                        client()
                    }
                    register("server") {
                        server()
                        programArgument("--nogui")
                    }
                }
            }
            parchment {
                minecraftVersion.set(parchmentMcVersion)
                mappingsVersion.set(parchmentVersion)
            }
        }
        sourceSets["main"].resources.srcDirs.add(project.file("src/generated/resources"))
        project.tasks.withType<JavaCompile>().configureEach {
            dependsOn(project.configurations["commonJava"])
            source(project.configurations["commonJava"])
        }
        project.tasks.withType<ProcessResources>().configureEach {
            dependsOn(project.configurations["commonResources"])
            from(project.configurations["commonResources"])
        }
        project.tasks.withType<Jar>().configureEach {
            from("../LICENSE.md")
        }
    }

    fun gameTests() {
        project.dependencies.add("testImplementation", "net.neoforged:testframework:${neoForgeVersion}")
        val sourceSets = project.extensions.getByType<JavaPluginExtension>().sourceSets
        project.extensions.getByType<NfExtension>().apply {
            runs {
                register("gameTestServer") {
                    type.set("gameTestServer")
                    systemProperty("neoforge.enabledGameTestNamespaces", modId!!)
                    sourceSet.set(sourceSets["test"])
                }
            }
        }
        // This avoids a build failure when running the "test" task, because there is no JUnit engine
        // in this subproject.
        // The test source set in this subproject is used for Minecraft game tests, not for JUnit tests.
        project.tasks.getByName("test").onlyIf { false }
    }

    fun dataGeneration(sourceProject: Project = project) {
        project.extensions.getByType<NfExtension>().apply {
            runs {
                create("data") {
                    data()
                    programArgument("--mod")
                    programArgument(modId!!)
                    programArgument("--all")
                    programArgument("--output")
                    programArgument(sourceProject.file("src/generated/resources/").absolutePath)
                    programArgument("--existing")
                    programArgument(sourceProject.file("src/main/resources/").absolutePath)
                }
            }
        }
    }
}