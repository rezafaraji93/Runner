plugins {
    alias(libs.plugins.runner.android.library)
}

android {
    namespace = "reza.droid.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}