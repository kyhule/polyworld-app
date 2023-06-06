rootProject.name = "polyworld-app"

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
}

plugins {
    id("com.github.kyhule.polyworld.build.settings") version "0.1.0"
}
