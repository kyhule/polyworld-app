import com.github.kyhule.polyworld.build.composeCompilerVersion

plugins {
    id("com.github.kyhule.polyworld.build.android-app")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }
}
