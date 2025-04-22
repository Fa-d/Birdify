package dev.faddy.bird_interfaces

import android.util.Log // Using Android Log for demonstration

// Interface for flying ability
interface CanFly {
    fun fly(distance: Int) // Example method
}

// Interface for swimming ability
interface CanSwim {
    fun swim(duration: Int) // Example method
}

// Interface for singing ability
interface CanSing {
    fun sing(song: String) // Example method
}

// --- Simple Feature Registry (Service Locator) ---
// This object will hold the implementations of our optional features.
// Modules that are included in the build will register their implementations here.
object BirdFeatureRegistry {
    private val features = mutableMapOf<Class<*>, Any>()

    /**
     * Registers an implementation for a given feature interface.
     * Only call this from the optional feature modules if they are included.
     */
    fun <T> registerFeature(interfaceClass: Class<T>, implementation: T) {
        features[interfaceClass] = implementation as Any
        Log.d("BirdFeatureRegistry", "Registered feature: ${interfaceClass.simpleName}")
    }

    /**
     * Retrieves the implementation for a given feature interface.
     * Returns null if the feature was not registered (i.e., the module was not included).
     */
    fun <T> getFeature(interfaceClass: Class<T>): T? {
        return features[interfaceClass] as? T
    }
}
