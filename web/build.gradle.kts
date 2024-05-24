import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import java.text.SimpleDateFormat
import java.util.*

plugins {
    alias(libs.plugins.kotlin.mpp)
    alias(libs.plugins.compose)
    alias(libs.plugins.buildconfig)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "portfoliowebapp.js"
            }
        }
        binaries.executable()
    }
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
                implementation(compose.components.resources)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.uiTest)
            }
        }
    }
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

val jsBrowserWebpack = tasks.getByName("jsBrowserProductionWebpack")

val copyDistributions by tasks.registering {
    doLast {
        copy {
            val destinationDir = File("$rootDir/public")
            if (!destinationDir.exists()) {
                destinationDir.mkdir()
            }
            println(layout.buildDirectory.asFile.get().absoluteFile)
            val distributions = File("${layout.buildDirectory.asFile.get().absoluteFile}/dist/js/productionExecutable/")
            from(distributions)
            into(destinationDir)
        }
    }
}

jsBrowserWebpack.finalizedBy(copyDistributions)
