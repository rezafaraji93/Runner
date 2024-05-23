plugins {
    alias(libs.plugins.runner.android.dynamic.feature)
}
android {
    namespace = "reza.droid.analytics.analytics_feature"
}

dependencies {
    implementation(project(":app"))
    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
}