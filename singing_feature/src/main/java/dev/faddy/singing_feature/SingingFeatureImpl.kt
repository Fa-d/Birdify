package dev.faddy.singing_feature

import android.util.Log
import dev.faddy.bird_interfaces.CanSing

class SingingFeatureImpl : CanSing {
    override fun sing(song: String) {
        Log.i("SingingFeature", "Bird is singing $song!")
    }
}

