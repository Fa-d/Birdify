package dev.faddy.singing_feature

import android.util.Log
import dev.faddy.bird_interfaces.BirdFeatureRegistry
import dev.faddy.bird_interfaces.CanSing
import dev.faddy.bird_interfaces.FeatureInitializer

class SingingFeatureInitializer : FeatureInitializer {
    constructor() {
        Log.d("SingingFeature", "SingingFeatureInitializer created.")
    }

    override fun initialize() {
        BirdFeatureRegistry.registerFeature(CanSing::class.java, SingingFeatureImpl())
        Log.d("SingingFeature", "SingingFeatureImpl registered via initializer.")
    }
}
