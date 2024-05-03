plugins {
    alias(libs.plugins.runner.android.library)
}

android {
    namespace = "reza.droid.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}