import info.solidsoft.gradle.pitest.PitestPlugin
import info.solidsoft.gradle.pitest.PitestPluginExtension
import me.modmuss50.mpp.ModPublishExtension
import me.modmuss50.mpp.MppPlugin
import me.modmuss50.mpp.ReleaseType
import me.modmuss50.mpp.platforms.modrinth.ModrinthEnvironment
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*
import org.sonarqube.gradle.SonarExtension
import org.sonarqube.gradle.SonarQubePlugin

class PublishingOptions {
    var maven: Boolean? = false
    var curseForge: String? = null
    var curseForgeRequiredDependencies: List<String>? = null
    var modrinth: String? = null
    var modrinthRequiredDependencies: List<String>? = null
    var client: Boolean = true
    var server: Boolean = true
}

open class BaseExtension(private val project: Project) {
    fun publishing(action: Action<PublishingOptions>) {
        val options = PublishingOptions()
        action.execute(options)
        if (options.maven == true) {
            enableMavenPublishing()
        }
        if (options.curseForge != null || options.modrinth != null) {
            project.plugins.apply(MppPlugin::class)
            project.extensions.getByType(ModPublishExtension::class).apply {
                val jar by project.tasks.getting(Jar::class)
                file.set(jar.archiveFile)
                val isNeoForge = project.pluginManager.hasPlugin("net.neoforged.moddev")
                if (isNeoForge) {
                    modLoaders.add("NeoForge")
                } else {
                    modLoaders.add("Fabric")
                }
                dryRun.set(System.getenv("RELEASE_DRY_RUN") == "true")
                type.set(
                    if (project.version.toString()
                            .contains("beta")
                    ) ReleaseType.BETA else if (project.version.toString()
                            .contains("alpha")
                    ) ReleaseType.ALPHA else ReleaseType.STABLE
                )
                changelog.set(System.getenv("RELEASE_CHANGELOG"))
                displayName.set("v" + project.version.toString())
                options.curseForge?.let {
                    curseforge {
                        accessToken.set(System.getenv("CURSEFORGE_TOKEN"))
                        minecraftVersions.add(mcVersion)
                        changelogType.set("markdown")
                        projectId.set(it)
                        client.set(options.client)
                        server.set(options.server)
                        options.curseForgeRequiredDependencies?.forEach { requires(it) }
                    }
                }
                options.modrinth?.let {
                    modrinth {
                        accessToken.set(System.getenv("MODRINTH_TOKEN"))
                        projectId.set(it)
                        minecraftVersions.add(mcVersion)
                        if (options.client && options.server) {
                            environment.set(ModrinthEnvironment.CLIENT_AND_SERVER)
                        } else if (options.client) {
                            environment.set(ModrinthEnvironment.CLIENT_ONLY)
                        } else if (options.server) {
                            environment.set(ModrinthEnvironment.SERVER_ONLY)
                        }
                        options.modrinthRequiredDependencies?.forEach { requires(it) }
                    }
                }
            }
        }
    }

    fun mutationTesting() {
        project.plugins.apply(PitestPlugin::class.java)
        project.extensions.getByType<PitestPluginExtension>().apply {
            junit5PluginVersion.set("1.2.3")
            pitestVersion.set("1.23.0")
            outputFormats.set(listOf("HTML", "XML"))
            mutationThreshold.set(90)
            coverageThreshold.set(80)
        }
    }

    fun testing() {
        project.tasks.withType<Test>().forEach {
            it.useJUnitPlatform()
        }
        project.dependencies.add("testRuntimeOnly", "org.junit.platform:junit-platform-launcher")
    }

    fun javadoc() {
        project.extra["refinedarchitect_javadoc"] = true
    }

    private fun enableMavenPublishing() {
        project.extensions.getByType<PublishingExtension>().apply {
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
            publications {
                create<MavenPublication>("mavenJava") {
                    from(project.components["java"])
                }
            }
        }
    }

    fun sonarQube(projectKey: String, organization: String = "refinedmods") {
        System.setProperty("sonar.gradle.skipCompile", "true")
        project.plugins.apply(SonarQubePlugin::class.java)
        project.extensions.getByType<SonarExtension>().apply {
            // https://docs.sonarqube.org/latest/analysis/github-integration/
            properties {
                property("sonar.projectKey", projectKey)
                property("sonar.organization", organization)
                property("sonar.host.url", "https://sonarcloud.io")
                property(
                    "sonar.coverage.jacoco.xmlReportPaths",
                    "${project.layout.buildDirectory.get()}/reports/jacoco/codeCoverageReportAggregate/codeCoverageReportAggregate.xml"
                )
            }
        }
    }
}
