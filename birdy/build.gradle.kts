plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dev.faddy.birdy"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":bird_interfaces"))
    val includedFeaturesString = "flying,singing"
    //  val includedFeaturesString: String? = project.findProperty("includedBirdFeatures") as? String
    val includedFeatures: List<String> = if (includedFeaturesString != null) {
        includedFeaturesString.split(",").map { it.trim() }
    } else {
        // Define a default set of features to include if the property is not set
        // Or throw an error if specifying features is mandatory
        println("Warning: 'includedBirdFeatures' property not set. Building with default or no optional features.")
        // listOf("flying", "swimming", "singing") // Example default
        emptyList()
    }

    // Conditionally include feature modules based on the list
    if (includedFeatures.contains("flying")) {
        implementation(project(":flying_feature"))
    }

    if (includedFeatures.contains("swimming")) {
        implementation(project(":swimming_feature"))
    }

    if (includedFeatures.contains("singing")) {
        implementation(project(":singing_feature"))
    }

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}