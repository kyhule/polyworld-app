plugins {
    id("com.autonomousapps.dependency-analysis")
}

dependencyAnalysis {
    issues {
        all {
            onAny { ignoreKtx(true) }
            onUnusedAnnotationProcessors {
                severity("fail")
            }
            onRedundantPlugins {
                severity("fail")
            }
        }
    }
    abi {
        exclusions {
            ignoreGeneratedCode()
            ignoreInternalPackages()
        }
    }
    dependencies {
        bundle("androidx-camera") {
            primary("androidx.camera:camera-camera2")
            includeGroup("androidx.camera")
        }
        bundle("androidx-paging") {
            primary("androidx.paging:paging-runtime")
            includeGroup("androidx.paging")
        }
        bundle("androidx-lifecycle") {
            primary("androidx.lifecycle:lifecycle-runtime")
            includeGroup("androidx.lifecycle")
            includeGroup("androidx.arch.core")
        }
        bundle("compose-animation") {
            primary("androidx.compose.animation:animation")
            includeGroup("androidx.compose.animation")
        }
        bundle("compose-foundation") {
            primary("androidx.compose.foundation:foundation")
            includeGroup("androidx.compose.foundation")
        }
        bundle("compose-runtime") {
            primary("androidx.compose.runtime:runtime")
            includeGroup("androidx.compose.runtime")
        }
        bundle("dagger") {
            includeGroup("com.google.dagger")
            includeDependency("javax.inject:javax.inject")
        }
        bundle("exoplayer") { includeGroup("com.google.android.exoplayer") }
        bundle("kotlin-stdlib") { includeGroup("org.jetbrains.kotlin") }
        bundle("leakcanary") {
            primary("com.squareup.leakcanary:leakcanary-android")
            includeGroup("com.squareup.leakcanary")
        }
        bundle("lint-tools") { includeGroup("com.android.tools.lint") }
        bundle("okhttp") {
            primary("com.squareup.okhttp3:okhttp")
            includeGroup("com.squareup.okhttp3")
        }
        bundle("paging") { includeGroup("androidx.paging") }
        bundle("robolectric") { includeGroup("org.robolectric") }
        bundle("rxjava") { includeGroup("io.reactivex.rxjava2") }
    }
}
