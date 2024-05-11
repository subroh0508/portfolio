allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.kotlin.mpp) apply false
    alias(libs.plugins.compose) apply false
}
