plugins {
    id("com.android.application")
    id("jacoco")
    id("org.sonarqube") version "3.5.0.2730"
}

sonarqube {
    properties {
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/coverage/androidTest/debug/connected/report.xml")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.organization", "comp-3013-team-5-2023-2024")
        property("sonar.projectKey", "COMP-3013-Team-5-2023-2024_TEAM-5-COMP-3018")
        property("sonar.projectName", "TEAM-5-COMP-3018")

    }
}

android {
    namespace = "com.example.periodtracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.periodtracker"
        minSdk = 32
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] =
                        "$projectDir/schemas"
            }
        }
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            enableAndroidTestCoverage  = true
            enableUnitTestCoverage = true
        }
        debug {
            enableAndroidTestCoverage  = true
            enableUnitTestCoverage = true
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    val room_version = "2.6.0"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    val material_design_version = "1.5.0"
    implementation ("com.google.android.material:material:$material_design_version")

    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:core:1.1.5")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
}

jacoco{
    toolVersion = "0.8.9"
}
