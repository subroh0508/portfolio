import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

val wasmJsBrowserTestReport by tasks.registering(TestReport::class) {
    destinationDirectory.set(layout.buildDirectory.file("reports/wasmJsBrowserTest").get().asFile)
    subprojects.forEach {
        val wasmJsBrowserTest by it.tasks.existing(KotlinJsTest::class)
        testResults.from(wasmJsBrowserTest.get().binaryResultsDirectory)
    }
}

plugins {
    alias(libs.plugins.kotlin.mpp) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.buildconfig) apply false
}
