plugins {
    id("org.ajoberstar.reckon")
}

reckon {
    setDefaultInferredScope("minor")
    setScopeCalc(calcScopeFromProp())
    snapshots()
    setStageCalc(calcStageFromProp())
}
