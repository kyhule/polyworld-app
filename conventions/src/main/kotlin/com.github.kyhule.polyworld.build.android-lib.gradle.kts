import com.github.kyhule.polyworld.build.configureTestOptions
import com.github.kyhule.polyworld.build.jdkVersion
import com.github.kyhule.polyworld.build.compileSdkVersion as polyCompileSdkVersion
import com.github.kyhule.polyworld.build.minSdkVersion
import com.github.kyhule.polyworld.build.targetSdkVersion

plugins {
    id("com.android.library")
    id("org.gradle.android.cache-fix")
    id("kotlin-android")
}

android {
    compileSdk = polyCompileSdkVersion

    defaultConfig {
        minSdk = minSdkVersion
        targetSdk = targetSdkVersion
    }

    buildTypes {
        debug {
            matchingFallbacks.add("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(jdkVersion)
        targetCompatibility = JavaVersion.toVersion(jdkVersion)
    }

    kotlinOptions {
        jvmTarget = jdkVersion.toString()
    }

    testOptions {
        configureTestOptions(project)
    }
}
