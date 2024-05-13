allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    alias(libs.plugins.kotlin.mpp) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.buildconfig) apply false
}
