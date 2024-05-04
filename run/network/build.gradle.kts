plugins {
    alias(libs.plugins.runner.android.library)
    alias(libs.plugins.runner.jvm.ktor)
}

android {
    namespace = "reza.droid.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}