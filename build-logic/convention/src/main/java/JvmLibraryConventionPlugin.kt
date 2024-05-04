import org.gradle.api.Plugin
import org.gradle.api.Project
import reza.droid.convention.configureKotlinJvm

class JvmLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
        }
    }
}