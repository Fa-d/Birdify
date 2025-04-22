package dev.faddy.bird_interfaces


/**
 * Common interface for all optional feature initializers.
 * Feature modules should provide an implementation of this interface.
 */
interface FeatureInitializer {
    /**
     * Initializes the specific feature. This method will be called by the BirdInitializer
     * if the feature module is included in the build.
     */
    fun initialize()
}
    