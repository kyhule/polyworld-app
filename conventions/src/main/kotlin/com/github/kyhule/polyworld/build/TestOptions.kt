package com.github.kyhule.polyworld.build

import com.android.build.api.dsl.TestOptions
import com.github.kyhule.polyworld.build.util.isCi
import com.github.kyhule.polyworld.build.util.isGithubActions
import com.github.kyhule.polyworld.build.util.isLinux
import com.github.kyhule.polyworld.build.util.synchronousEnvProperty
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.findByType
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension

internal fun TestOptions.configureTestOptions(project: Project) {
    animationsDisabled = true

    unitTests {
        isReturnDefaultValues = true
        isIncludeAndroidResources = true

        all { task -> task.configureTest(project) }
    }
}

internal fun Test.configureTest(project: Project) {
    if (project.testVerboseLogging) {
        // Add additional logging on Jenkins to help debug hanging or OOM-ing unit tests.
        testLogging {
            showStandardStreams = true
            showStackTraces = true

            // Set options for log level LIFECYCLE
            events("started", "passed", "failed", "skipped")
            setExceptionFormat("short")

            // Setting this to 0 (the default is 2) will display the test executor that each test is running on.
            displayGranularity = 0
        }
    }

    // https://github.com/gradle/gradle/issues/5184#issuecomment-457865951
    extensions.findByType(JacocoTaskExtension::class)?.apply {
        isIncludeNoLocationClasses = true
        excludes = excludes.orEmpty() + listOf(
            "jdk.internal.*"
        )
    }

    minHeapSize = project.testMinHeapSize
    maxHeapSize = project.testMaxHeapSize

    // Run unit tests in parallel if multiple CPUs are available. Use at most half the available CPUs.
    maxParallelForks = maxOf(Runtime.getRuntime().availableProcessors() / 2, 1)
    setForkEvery(project.testForkEvery)

    jvmArgs(
        // Cover for illegal reflection warnings
        // https://github.com/square/retrofit/issues/3557
        "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
        // Robolectric 4.9+ requires these --add-opens options.
        // https://github.com/robolectric/robolectric/issues/7456
        "--add-opens=java.base/java.lang=ALL-UNNAMED",
        "--add-opens=java.base/java.util=ALL-UNNAMED",
    )
    if (project.isCi) {
        // Shuttle has 32 cores but only 64GB memory, so we want to limit parallel forks
        maxParallelForks = project.ciTestMaxParallelForks
        // Improve JVM memory behavior in tests to avoid OOMs but only on Linux
        if (project.isLinux()) {
            jvmArgs("-XX:+UseContainerSupport")
        }
        val workspaceDir = when {
            project.isGithubActions -> project.synchronousEnvProperty("GITHUB_WORKSPACE")
            else -> project.rootProject.projectDir.absolutePath
        }
        jvmArgs(
            "-XX:+HeapDumpOnOutOfMemoryError",
            "-XX:+UseGCOverheadLimit",
            "-XX:GCHeapFreeLimit=10",
            "-XX:GCTimeLimit=20",
            "-XX:HeapDumpPath=$workspaceDir/fs_oom_err_pid<pid>.hprof",
            "-XX:OnError=cat $workspaceDir/fs_oom.log",
            "-XX:OnOutOfMemoryError=cat $workspaceDir/fs_oom_err_pid<pid>.hprof",
            "-Xss1m" // Stack size
        )
    }
}
