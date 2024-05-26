import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest

plugins {
    alias(libs.plugins.kotlin.mpp) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.buildconfig) apply false

    alias(libs.plugins.detekt)
}

val wasmJsBrowserTestReport by tasks.registering(TestReport::class) {
    destinationDirectory.set(layout.buildDirectory.file("reports/wasmJsBrowserTest").get().asFile)
    subprojects.forEach {
        val wasmJsBrowserTest by it.tasks.existing(KotlinJsTest::class)
        testResults.from(wasmJsBrowserTest.get().binaryResultsDirectory)
    }
}

dependencies {
    detektPlugins(libs.detekt.formatting)
}

val detektAll by tasks.registering(Detekt::class) {
    description = "Runs the Lint check whole project at once."

    basePath = rootProject.projectDir.absolutePath
    parallel = true
    autoCorrect = true
    setSource(files(rootProject.projectDir))
    config.setFrom(listOf(rootProject.files("config/detekt.yml")))

    include("**/*.kt", "**/**.kts")
    exclude("**/resources/**", "**/composeResources/**","**/build/**")

    reports {
        html {
            required.set(true)
            outputLocation.set(rootProject.file("lint-reports/kotlin/detekt.html"))
        }

        sarif {
            required.set(true)
            outputLocation.set(rootProject.file("lint-reports/kotlin/detekt.sarif"))
        }

        txt {
            required.set(false)
        }
    }
}
