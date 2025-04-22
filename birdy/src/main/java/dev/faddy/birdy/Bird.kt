package dev.faddy.birdy

import android.util.Log
import dev.faddy.bird_interfaces.BirdFeatureRegistry
import dev.faddy.bird_interfaces.BirdInitializer
import dev.faddy.bird_interfaces.CanFly
import dev.faddy.bird_interfaces.CanSing
import dev.faddy.bird_interfaces.CanSwim

/**
 * Represents a Bird that can potentially have optional features
 * like flying, swimming, or singing, depending on the build configuration.
 * It uses the BirdFeatureRegistry to access these features safely.
 */
class Bird(val name: String) {

    init {
        BirdInitializer.initializeOptionalFeatures()
    }

    private val TAG = "Bird"

    /**
     * Attempts to make the bird fly.
     * Checks the registry for a CanFly implementation.
     */
    fun attemptToFly(distance: Int) {
        val flyer = BirdFeatureRegistry.getFeature(CanFly::class.java)
        if (flyer != null) {
            Log.i(TAG, "$name is attempting to fly...")
            flyer.fly(distance)
        } else {
            Log.w(TAG, "$name cannot fly. Flying feature not available.")
            // Handle the absence of the feature gracefully
        }
    }


    /**
     * Attempts to make the bird swim.
     * Checks the registry for a CanSwim implementation.
     */
    fun attemptToSwim(duration: Int) {
        val swimmer = BirdFeatureRegistry.getFeature(CanSwim::class.java)
        if (swimmer != null) {
            Log.i(TAG, "$name is attempting to swim...")
            swimmer.swim(duration)
        } else {
            Log.w(TAG, "$name cannot swim. Swimming feature not available.")
            // Handle the absence of the feature gracefully
        }
    }

    /**
     * Attempts to make the bird sing.
     * Checks the registry for a CanSing implementation.
     */
    fun attemptToSing(song: String) {
        val singer = BirdFeatureRegistry.getFeature(CanSing::class.java)
        if (singer != null) {
            Log.i(TAG, "$name is attempting to sing...")
            singer.sing(song)
        } else {
            Log.w(TAG, "$name cannot sing. Singing feature not available.")
            // Handle the absence of the feature gracefully
        }
    }

    // Core bird functionality that doesn't depend on optional modules
    fun eat() {
        Log.i(TAG, "$name is eating.")
    }
}
