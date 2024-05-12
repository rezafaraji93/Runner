plugins {
    alias(libs.plugins.runner.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(projects.core.domain)
}