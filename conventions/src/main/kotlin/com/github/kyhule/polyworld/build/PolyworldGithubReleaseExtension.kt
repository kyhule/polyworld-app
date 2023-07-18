package com.github.kyhule.polyworld.build

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

open class PolyworldGithubReleaseExtension @Inject constructor(
    objects: ObjectFactory
) {
    val dryRun: Property<Boolean> = objects.property<Boolean>().convention(false)
    val owner: Property<CharSequence> = objects.property<CharSequence>().convention("kyhule")
    val token: Property<CharSequence> = objects.property<CharSequence>().convention(System.getenv("GITHUB_TOKEN"))

    companion object {
        const val name = "polyworldGithubRelease"

        internal fun create(project: Project): PolyworldGithubReleaseExtension = project.extensions.create(name)
    }
}
