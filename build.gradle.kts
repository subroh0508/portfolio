plugins {
    alias(libs.plugins.kotlin.mpp)
    alias(libs.plugins.compose)
}

group = "net.subroh0508"
version = "1.0-SNAPSHOT"

kotlin {
    js(IR) {
        binaries.executable()
        browser {

        }
    }

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
            }
        }

        named("commonTest") {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        named("jsMain") {}
        named("jsTest") {}
    }
}

compose.experimental {
    web.application {}
}
