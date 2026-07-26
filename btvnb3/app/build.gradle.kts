plugins {

    alias(libs.plugins.android.application)

    alias(libs.plugins.kotlin.android)

}


android {

    namespace = "com.example.loginui"

    compileSdk = 36


    defaultConfig {

        applicationId = "com.example.loginui"

        minSdk = 24

        targetSdk = 36

        versionCode = 1

        versionName = "1.0"


        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"

    }


    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )

        }

    }


    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_17

        targetCompatibility = JavaVersion.VERSION_17

    }


    kotlinOptions {

        jvmTarget = "17"

    }


}


dependencies {


    implementation(
        "androidx.core:core-ktx:1.15.0"
    )


    implementation(
        "androidx.appcompat:appcompat:1.7.0"
    )


    implementation(
        "com.google.android.material:material:1.12.0"
    )


    implementation(
        "androidx.activity:activity-ktx:1.9.3"
    )


    implementation(
        "androidx.constraintlayout:constraintlayout:2.2.0"
    )


}