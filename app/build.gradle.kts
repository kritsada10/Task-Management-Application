plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.6.21-1.0.6"
}

android {
    namespace = "com.exam.examrbh"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.exam.examrbh"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField ("String", "API_URL", "\"${providers.gradleProperty("API_URL").get()}\"")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
    }
    kapt{
        generateStubs = true
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation ("androidx.core:core-splashscreen:1.0.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:5.0.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*Dagger*/
    implementation ("com.google.dagger:dagger:2.48")
    implementation ("com.google.dagger:dagger-android:2.48")
    implementation ("com.google.dagger:dagger-android-support:2.48")
    kapt ("com.google.dagger:dagger-android-processor:2.48")
    kapt ("com.google.dagger:dagger-compiler:2.48")

    /*Retrofit*/
    implementation ("com.squareup.retrofit2:retrofit:2.8.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.8.1")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.7.2")
    implementation ("com.squareup.okhttp3:okhttp:4.4.1")
    implementation ("com.google.code.gson:gson:2.8.6")

    /*Rx*/
    implementation ("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation ("com.jakewharton.rxbinding3:rxbinding-core:3.1.0")
    implementation ("com.jakewharton.rxbinding3:rxbinding-appcompat:3.1.0")


}