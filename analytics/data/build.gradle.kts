plugins {
    alias(libs.plugins.runner.android.library)
}

android {
    namespace = "reza.droid.analytics.data"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)

    implementation(libs.bundles.koin)
}