plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    compileOnly(gradleApi())
    implementation(libs.gradlePlugin.android)
    implementation(libs.gradlePlugin.dependencyAnalysis)
    implementation(libs.gradlePlugin.doctor)
    implementation(libs.gradlePlugin.githubRelease)
    implementation(libs.gradlePlugin.gradleAndroidCacheFix)
    implementation(libs.gradlePlugin.kotlin)
    implementation(libs.gradlePlugin.mavenPublish)
    implementation(libs.gradlePlugin.reckon)
    implementation(libs.gradlePlugin.sonar)
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])

// Add a task to run the functional tests
val functionalTest by tasks.registering(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
    useJUnitPlatform()
}

gradlePlugin.testSourceSets.add(functionalTestSourceSet)

tasks.named<Task>("check") {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}

tasks.named<Test>("test") {
    // Use JUnit Jupiter for unit tests.
    useJUnitPlatform()
}

