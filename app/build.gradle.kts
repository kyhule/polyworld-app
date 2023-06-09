plugins {
    `polyworld-android-app`
}

android {
    namespace = "com.github.kyhule.polyworld.app"
    defaultConfig {
        applicationId = "com.github.kyhule.polyworld.app"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.ui.theme)
    implementation(externalLibs.androidx.coreKtx)
    implementation(externalLibs.androidx.lifecycle.runtimeKtx)
    implementation(externalLibs.androidx.activity.compose)
    implementation(externalLibs.androidx.compose.ui)
    implementation(externalLibs.androidx.compose.uiGraphics)
    implementation(externalLibs.androidx.compose.uiToolingPreview)
    implementation(externalLibs.androidx.compose.material3)
    testImplementation(externalLibs.junit)
    androidTestImplementation(externalLibs.androidx.test.extJunit)
    androidTestImplementation(externalLibs.androidx.test.espressoCore)
    androidTestImplementation(externalLibs.androidx.compose.uiTestJunit4)
    debugImplementation(externalLibs.androidx.compose.uiTooling)
    debugImplementation(externalLibs.androidx.compose.uiTestManifest)
}
