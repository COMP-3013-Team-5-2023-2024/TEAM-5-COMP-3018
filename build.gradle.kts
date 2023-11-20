// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("jacoco")
    id("org.sonarqube") version "3.5.0.2730"
}

sonarqube {
    properties {
        property("sonar.coverage.jacoco.xmlReportPaths", "app/build/reports/coverage/androidTest/debug/connected/report.xml")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.organization", "comp-3013-team-5-2023-2024")
        property("sonar.projectKey", "COMP-3013-Team-5-2023-2024_TEAM-5-COMP-3018")
        property("sonar.projectName", "TEAM-5-COMP-3018")
    }
}