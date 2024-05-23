plugins {
    alias(libs.plugins.runner.android.feature.ui)
}

android {
    namespace = "reza.droid.analytics.presentation"
}

dependencies {

    implementation(projects.analytics.domain)
}