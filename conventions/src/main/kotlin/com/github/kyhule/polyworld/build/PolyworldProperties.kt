package com.github.kyhule.polyworld.build

import com.github.kyhule.polyworld.build.util.*
import com.github.kyhule.polyworld.build.util.booleanProperty
import com.github.kyhule.polyworld.build.util.longProperty
import org.gradle.api.Project
import org.gradle.api.provider.Provider

val Project.compileSdkVersion: Int
    get() = intProperty("polyworld.compileSdkVersion", defaultValue = 33)

val Project.minSdkVersion: Int
    get() = intProperty("polyworld.minSdkVersion", defaultValue = 24)

val Project.targetSdkVersion: Int
    get() = intProperty("polyworld.targetSdkVersion", defaultValue = 33)

val Project.jdkVersion: Int
    get() = intProperty("polyworld.jdkVersion", defaultValue = 17)

val Project.composeCompilerVersion: String
    get() = stringProperty("polyworld.jdkVersion", defaultValue = "1.4.7")

/** Flag to enable verbose logging in unit tests. */
val Project.testVerboseLogging: Boolean
    get() = booleanProperty("polyworld.test.verboseLogging")

/**
 * Property corresponding to the number unit tests to run on a fork before it is disposed.
 * This helps when tests leak memory.
 *
 * **See Also:** [Forking options](https://docs.gradle.org/current/userguide/performance.html#forking_options)
 */
val Project.testForkEvery: Long
    get() = longProperty("polyworld.test.forkEvery", 500L)

/**
 * Property corresponding to the number unit tests to run on a fork before it is disposed.
 * This helps when tests leak memory.
 *
 * **See Also:** [Forking options](https://docs.gradle.org/current/userguide/performance.html#forking_options)
 */
val Project.testMinHeapSize: String
    get() = stringProperty("polyworld.test.minHeapSize", "128m")

/**
 * Property corresponding to the number unit tests to run on a fork before it is disposed.
 * This helps when tests leak memory.
 *
 * **See Also:** [Forking options](https://docs.gradle.org/current/userguide/performance.html#forking_options)
 */
val Project.testMaxHeapSize: String
    get() = stringProperty("polyworld.test.maxHeapSize", "1g")

/**
 * Property corresponding to the number of parallel forks to create for executing unit tests in CI.
 *
 * **See Also:** [Parallel test execution](https://docs.gradle.org/current/userguide/performance.html#parallel_test_execution)
 */
val Project.ciTestMaxParallelForks: Int
    get() = intProperty("polyworld.ci.test.maxParallelForks", 4)

/**
 * Property corresponding to whether tests that initially fail and then pass on retry should fail the task.
 *
 * **See Also:** [Using Test Retry](https://docs.gradle.com/enterprise/gradle-plugin/#test_retry)
 */
val Project.testRetryFailOnPassedAfterRetry: Provider<Boolean>
    get() = project.booleanProvider("polyworld.test.retry.failOnPassedAfterRetry", defaultValue = false)

/**
 * Property corresponding to the maximum number of test failures that are allowed before retrying is disabled.
 *
 * **See Also:** [Using Test Retry](https://docs.gradle.com/enterprise/gradle-plugin/#test_retry)
 */
val Project.testRetryMaxFailures: Provider<Int>
    get() = project.intProvider("polyworld.test.retry.maxFailures", defaultValue = 20)

/**
 * Property corresponding to the maximum number of times to retry an individual test.
 *
 * **See Also:** [Using Test Retry](https://docs.gradle.com/enterprise/gradle-plugin/#test_retry)
 */
val Project.testRetryMaxRetries: Provider<Int>
    get() = project.intProvider("polyworld.test.retry.maxRetries", defaultValue = 1)
