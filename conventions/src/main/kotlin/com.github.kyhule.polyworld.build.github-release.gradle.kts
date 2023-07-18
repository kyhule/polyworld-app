import com.github.kyhule.polyworld.build.PolyworldGithubReleaseExtension

plugins {
    id("com.github.breadmoirai.github-release")
}

val extension = PolyworldGithubReleaseExtension.create(project)

githubRelease {
    dryRun(extension.dryRun)
    token(extension.token)
    owner(extension.owner)
    releaseName { version.toString() }
    tagName { version.toString() }
    generateReleaseNotes { true }
}
