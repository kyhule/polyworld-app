package com.github.kyhule.polyworld.build.util

import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory

/** If true, this is currently running on any CI. */
val Settings.isCi: Boolean
    get() = providers.isCi

/** If true, this is currently running on any CI. */
val Project.isCi: Boolean
    get() = providers.isCi

/** If true, this is currently running on GitHub Actions CI. */
val Project.isGithubActions: Boolean
    get() = providers.isGithubActions

internal val ProviderFactory.isCi: Boolean
    get() = isGithubActions


/** If true, this is currently running on GitHub Actions CI. */
val ProviderFactory.isGithubActions: Boolean
    get() = githubActions.isPresent

internal val ProviderFactory.githubActions: Provider<String>
    get() = environmentVariable("GITHUB_ACTIONS")
