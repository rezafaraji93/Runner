import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import reza.droid.convention.addUiLayerDependencies
import reza.droid.convention.libs

class AndroidFeatureUiComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runner.android.library.compose")
            }

            dependencies {
                addUiLayerDependencies(target)
            }
        }
    }
}