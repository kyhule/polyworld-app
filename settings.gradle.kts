rootProject.name = "polyworld-app"
include(":app")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/kyhule/*")
            credentials(PasswordCredentials::class)
        }
    }
    if (file("../polyworld-gradle-plugin/.composite-include").exists()) {
        includeBuild("../polyworld-gradle-plugin") {
            logger.lifecycle("Including polyworld-gradle-plugin...")
        }
    }
}

plugins {
    id("com.github.kyhule.polyworld.build.settings") version "0.2.0-SNAPSHOT"
}
