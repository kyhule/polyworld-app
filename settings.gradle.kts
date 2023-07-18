rootProject.name = "polyworld-app"

include(":app")

pluginManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("conventions")
}

plugins {
    id("com.github.kyhule.polyworld.build.settings")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("externalLibs") {
            from(files("gradle/externalLibs.versions.toml"))
        }
    }
}

if (file("../polyworld-theme/.composite-include").exists()) {
    logger.lifecycle("Including polyworld-theme...")
    includeBuild("../polyworld-theme") {
        dependencySubstitution {
            substitute(module("com.github.kyhule.polyworld.ui:theme")).using(project(":theme"))
        }
    }
}
