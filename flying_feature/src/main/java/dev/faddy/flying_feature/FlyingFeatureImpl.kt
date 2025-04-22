package dev.faddy.flying_feature

import android.util.Log
import dev.faddy.bird_interfaces.BirdFeatureRegistry
import dev.faddy.bird_interfaces.CanFly
import dev.faddy.bird_interfaces.FeatureInitializer

// Implementation of the CanFly interface
class FlyingFeatureImpl : CanFly {
    override fun fly(distance: Int) {
        Log.i("FlyingFeature", "Bird is flying $distance meters!")
        // ... flying logic
    }
}

// A simple object or function to register the feature when the module is loaded.
// This could be called from an Application class, a custom initializer,
// or even statically if appropriate for your project structure.
class FlyingFeatureInitializer : FeatureInitializer {
    constructor() {
        Log.d("FlyingFeature", "FlyingFeatureInitializer created.")
    }
    override fun initialize() {
        BirdFeatureRegistry.registerFeature(CanFly::class.java, FlyingFeatureImpl())
        Log.d("FlyingFeature", "FlyingFeatureImpl registered via initializer.")
    }
}

// You might call initialize() from your Application class or a dedicated initializer.
// Example: In your main app's Application.onCreate()
// FlyingFeatureInitializer.initialize() // ONLY if flying_feature is included
