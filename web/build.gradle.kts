plugins {
    alias(libs.plugins.kotlin.mpp)
    alias(libs.plugins.compose)
}

kotlin {
    wasm {
        moduleName = "portfoliowebapp"
        binaries.executable()
        browser {}
    }

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }

        named("commonTest") {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        named("wasmMain") {}
        named("wasmTest") {}
    }
}

compose.experimental {
    web.application {}
}

compose {
    kotlinCompilerPlugin.set(libs.versions.compose.wasm.get())
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=${libs.versions.kotlin.get()}")
}
