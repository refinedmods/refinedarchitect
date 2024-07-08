subprojects {
    group = "com.refinedmods.refinedarchitect"
}

allprojects {
    version = "0.0.0"

    if (System.getenv("GITHUB_SHA") != null) {
        version = "0.0.0+" + System.getenv("GITHUB_SHA").substring(0, 7)
    }

    if (System.getenv("RELEASE_VERSION") != null) {
        version = System.getenv("RELEASE_VERSION")
    }
}

tasks.register("codeCoverageReportAggregate") {
    // no op
}
