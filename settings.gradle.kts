pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }

    plugins {
        val kotlinVersion: String by settings
        val kvisionVersion: String by settings

        kotlin("js") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("io.kvision") version kvisionVersion
    }
}

rootProject.name = "kotlin-js-web-app-template"
