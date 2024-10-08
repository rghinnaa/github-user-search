plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKSP)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navSafeArgs)
}

android {
    namespace = "com.project.githubusersearch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.githubusersearch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField(
            "String",
            "AUTH_KEY",
            "\"${project.findProperty("AUTH_KEY")}\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.gson)
    implementation(libs.squareup.moshi)

    implementation(libs.hilt)
    implementation(libs.hilt.navigation)

    implementation(libs.androidx.viewmodel.ktx)
    implementation(libs.androidx.viewmodel.runtime)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.livedata.ktx)
    implementation(libs.androidx.paging)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.runtime)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.paging)

    implementation(libs.glide)
    implementation(libs.androidx.runner)

    ksp(libs.glide.compiler)
    ksp(libs.hilt.compiler)
    ksp(libs.androidx.room.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.coroutine.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.rule)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)
}