plugins {
    `polyworld-android-app`
    `polyworld-android-app-compose`
}

android {
    namespace = "com.github.kyhule.polyworld.app"
    defaultConfig {
        applicationId = "com.github.kyhule.polyworld.app"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(externalLibs.androidx.activity.compose)
    implementation(externalLibs.androidx.coreKtx)
    implementation(externalLibs.androidx.lifecycle.runtimeKtx)
    implementation(externalLibs.androidxComposeMaterial3.material3)
    implementation(externalLibs.androidxComposeUi.ui)
    implementation(externalLibs.androidxComposeUi.uiGraphics)
    implementation(externalLibs.androidxComposeUi.uiToolingPreview)
    implementation(libs.ui.theme)

    debugImplementation(externalLibs.androidxComposeUi.uiTestManifest)
    debugImplementation(externalLibs.androidxComposeUi.uiTooling)

    testImplementation(externalLibs.junit)

    androidTestImplementation(externalLibs.androidx.test.espressoCore)
    androidTestImplementation(externalLibs.androidx.test.extJunit)
    androidTestImplementation(externalLibs.androidxComposeUi.uiTest)
}
