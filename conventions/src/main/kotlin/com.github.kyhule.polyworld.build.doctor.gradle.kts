plugins {
    id("com.osacky.doctor")
}

doctor {
    // disabled as it is debatable whether it is truly faster
    warnWhenNotUsingParallelGC.set(false)
}
