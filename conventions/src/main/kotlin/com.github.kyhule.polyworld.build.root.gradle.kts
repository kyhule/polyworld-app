plugins {
    id("com.github.kyhule.polyworld.build.dependency-analysis")
    id("com.github.kyhule.polyworld.build.doctor")
}

tasks.register("clean") {
    delete(buildDir)
}
