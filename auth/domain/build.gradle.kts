plugins {
    alias(libs.plugins.runner.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}