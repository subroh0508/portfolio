import java.text.SimpleDateFormat
import java.util.*

plugins {
    alias(libs.plugins.kotlin.mpp)
    alias(libs.plugins.compose)
    alias(libs.plugins.buildconfig)
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "portfoliowebapp.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

compose.experimental {
    web.application {}
}


fun Project.localProperties(): Properties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

buildConfig {
    useKotlinOutput { topLevelConstants = true }

    buildConfigField(
        "LAST_MODIFIED_DATE_TIME",
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(Date()),
    )
}
