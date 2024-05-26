import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest
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

buildConfig {
    useKotlinOutput { topLevelConstants = true }

    buildConfigField(
        "LAST_MODIFIED_DATE_TIME",
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(Date()),
    )
}

val wasmJsBrowserTest by tasks.existing(KotlinJsTest::class) {
    reports.junitXml.required.set(true)
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED)
    }
}

val copyDistributions by tasks.registering {
    doLast {
        copy {
            val destinationDir = File("$rootDir/public")
            if (!destinationDir.exists()) {
                destinationDir.mkdir()
            }
            val distributions =
                File("${layout.buildDirectory.asFile.get().absoluteFile}/dist/wasmJs/productionExecutable/")
            from(distributions)
            into(destinationDir)
        }
    }
}

val wasmJsBrowserProductionWebpack by tasks.existing {
    finalizedBy(copyDistributions)
}
