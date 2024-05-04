plugins {
    alias(libs.plugins.runner.android.feature.ui)
}

android {
    namespace = "reza.droid.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}