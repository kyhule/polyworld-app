import com.github.kyhule.polyworld.build.composeCompilerVersion

plugins {
    id("com.github.kyhule.polyworld.build.android-lib")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }
}
