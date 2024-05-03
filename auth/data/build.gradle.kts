plugins {
    alias(libs.plugins.runner.android.library)
}

android {
    namespace = "reza.droid.auth.data"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}