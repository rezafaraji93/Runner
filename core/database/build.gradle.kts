plugins {
    alias(libs.plugins.runner.android.library)

}

android {
    namespace = "reza.droid.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}