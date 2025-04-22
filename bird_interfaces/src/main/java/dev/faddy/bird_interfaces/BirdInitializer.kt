package dev.faddy.bird_interfaces

import android.util.Log
import java.util.ServiceLoader


/**
 * This object is responsible for initializing optional bird features
 * by discovering implementations of FeatureInitializer using ServiceLoader.
 * It will automatically find and run initializers for feature modules
 * that are included in the build and correctly configured for ServiceLoader.
 */
object BirdInitializer {

    /**
     * Discovers and initializes all available optional features
     * by loading implementations of FeatureInitializer using ServiceLoader.
     * This should be called early in the application lifecycle (e.g., Application.onCreate()).
     */
    fun initializeOptionalFeatures() {
        Log.d(TAG, "Attempting to initialize optional bird features using ServiceLoader...")

        // Use ServiceLoader to find all implementations of FeatureInitializer
        val serviceLoader = ServiceLoader.load(FeatureInitializer::class.java)

        // Iterate through found initializers and run them
        val initializers = serviceLoader.iterator()
        if (!initializers.hasNext()) {
            Log.d(TAG, "No FeatureInitializer implementations found.")
        }

        while (initializers.hasNext()) {
            try {
                val initializer = initializers.next()
                Log.d(
                    TAG, "Found FeatureInitializer implementation: ${initializer::class.java.name}"
                )
                initializer.initialize()
                Log.i(
                    TAG,
                    "Successfully initialized feature via: ${initializer::class.java.simpleName}"
                )
            } catch (e: Exception) {
                // Catch exceptions during the initialization of a specific feature
                Log.e(TAG, "An error occurred during initialization of a feature.", e)
            }
        }

        Log.d(TAG, "Finished attempting to initialize optional bird features.")
    }
}

private const val TAG = "BirdInitializer"
