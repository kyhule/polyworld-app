@file:Suppress("unused")

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.`polyworld-android-app`: PluginDependencySpec
    get() = polyworld("android-app")
val PluginDependenciesSpec.`polyworld-android-app-compose`: PluginDependencySpec
    get() = polyworld("android-app-compose")

val PluginDependenciesSpec.`polyworld-android-lib`: PluginDependencySpec
    get() = polyworld("android-lib")

val PluginDependenciesSpec.`polyworld-android-lib-compose`: PluginDependencySpec
    get() = polyworld("android-lib-compose")
val PluginDependenciesSpec.`polyworld-root`: PluginDependencySpec
    get() = polyworld("root")

val PluginDependenciesSpec.`polyworld-github-release`: PluginDependencySpec
    get() = polyworld("github-release")

val PluginDependenciesSpec.`polyworld-maven-publish`: PluginDependencySpec
    get() = polyworld("maven-publish")

val PluginDependenciesSpec.`polyworld-versioning`: PluginDependencySpec
    get() = polyworld("versioning")

internal fun PluginDependenciesSpec.polyworld(
    name: String,
    version: String? = null
): PluginDependencySpec =
    if (version.isNullOrBlank()) id("com.github.kyhule.polyworld.build.$name")
    else id("com.xfinity.dh.build.$name").version(version)
