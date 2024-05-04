import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import reza.droid.convention.ExtensionType
import reza.droid.convention.configureBuildTypes
import reza.droid.convention.configureKotlinAndroid
import reza.droid.convention.libs

class AndroidLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.library
                )
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
            dependencies {
                "testImplementation"(kotlin("test"))
                "androidTestImplementation"(libs.findLibrary("androidx.test").get())
                "androidTestImplementation"(libs.findLibrary("androidx.junit").get())

            }
        }
    }
}