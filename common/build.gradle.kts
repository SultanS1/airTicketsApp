plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.test.common"
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.defaultConfig.minSdk
        testInstrumentationRunner = Configs.defaultConfig.testInstrumentationRunner
        consumerProguardFiles(file(Configs.defaultConfig.consumerProguardFiles))
    }

    buildTypes {
        release {
            isMinifyEnabled = Configs.buildTypes.release.isMinifyEnabled
            proguardFiles(
                file(Configs.buildTypes.release.proguardFiles.androidOptimize),
                file(Configs.buildTypes.release.proguardFiles.customRules)
            )
        }
    }
    compileOptions {
        sourceCompatibility = Configs.compileOptions.sourceCompatibility
        targetCompatibility = Configs.compileOptions.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Configs.kotlinOptions.jvmTarget
    }

}

dependencies {

    api(libs.viewBindingDelegate)

    api(libs.koin.core)
    api(libs.koin.android)

    api(libs.glide)

    api(libs.cicerone)

    api(libs.gson)
    api(libs.retrofit)
    api(libs.gson.converter)
    api(libs.okHttp)

    api(libs.viewModelLifeCycle)

    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.junit)
    api(libs.androidx.junit)
    api(libs.androidx.espresso.core)
}