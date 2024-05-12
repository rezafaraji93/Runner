plugins {
    alias(libs.plugins.runner.android.library)
}

android {
    namespace = "reza.droid.run.location"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(projects.core.domain)
    implementation(projects.run.domain)

    implementation(libs.bundles.koin)
}