import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("js")
    kotlin("plugin.serialization")
    id("io.kvision")
}

val projectGroup: String by project
val projectVersion: String by project

group = projectGroup
version = projectVersion

repositories {
    mavenCentral()
}

val kotlinVersion: String by project
val kvisionVersion: String by project

dependencies {
    implementation("io.kvision:kvision:$kvisionVersion")
    implementation("io.kvision:kvision-state:$kvisionVersion")
    implementation("io.kvision:kvision-bootstrap:$kvisionVersion")
    implementation("io.kvision:kvision-bootstrap-css:$kvisionVersion")
}

val webDir = file("src/main/web")

kotlin {
    js {
        browser {
            val outputFile = "main.bundle.js"

            runTask {
                outputFileName = outputFile
                sourceMaps = false
                devServer = KotlinWebpackConfig.DevServer(
                    open = false,
                    port = 8080,
                    static = mutableListOf("$buildDir/processedResources/js/main")
                )
            }

            webpackTask {
                outputFileName = outputFile
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }

        binaries.executable()
    }

    sourceSets["main"].resources.srcDir(webDir)
}
