import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import reza.droid.convention.configureAndroidCompose

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runner.android.library")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(commonExtension = extension)
        }
    }
}