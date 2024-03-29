import Libs.Compose.ComposeBomPlatform

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.kamalbramwell.dating"
    compileSdk = Versions.Sdk.Compile

    defaultConfig {
        applicationId = "com.kamalbramwell.dating"
        minSdk = Versions.Sdk.Min
        targetSdk = Versions.Sdk.Target
        versionCode = Versions.Project.Code
        versionName = Versions.Project.Name

        testInstrumentationRunner = "com.kamalbramwell.dating.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.ComposeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(Libs.Core.Ktx)
    implementation(Libs.Core.LifecycleRuntime)

    implementation(Libs.DI.Hilt)
    implementation(Libs.DI.HiltNavigationCompose)
    testImplementation(Libs.DI.HiltTest)
    androidTestImplementation(Libs.DI.HiltTest)
    kapt(Libs.DI.HiltKapt)
    kaptTest(Libs.DI.HiltKapt)
    kaptAndroidTest(Libs.DI.HiltKapt)

    val composeBom = platform(ComposeBomPlatform)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(Libs.Compose.Material3)
    implementation(Libs.Compose.ToolingPreview)
    implementation(Libs.Compose.IconsCore)
    implementation(Libs.Compose.IconsExtended)
    implementation(Libs.Compose.WindowSizeClass)
    implementation(Libs.Compose.Activity)
    implementation(Libs.Compose.ViewModel)
    implementation(Libs.Compose.LifecycleRuntime)
    implementation(Libs.Compose.Navigation)
    implementation(Libs.Compose.Ui)
    implementation(Libs.Compose.Material)
    implementation(Libs.Compose.Accompanist)
    implementation(Libs.Compose.Coil)
    implementation(Libs.Compose.ConstraintLayout)

    androidTestImplementation(Libs.Compose.AndroidTestJunit)
    androidTestImplementation(Libs.Compose.NavigationAndroidTest)
    debugImplementation(Libs.Compose.DebugToolingUi)
    debugImplementation(Libs.Compose.DebugTestManifest)

    implementation(Libs.Data.DataStore)

    testImplementation(Libs.Test.CoroutinesTest)
    testImplementation(Libs.Test.TestJunit)
    androidTestImplementation(Libs.Test.AndroidTestJunit)
    androidTestImplementation(Libs.Test.AndroidTestEspresso)
}