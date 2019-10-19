package sanchez.sanchez.sergio.agrociety

import sanchez.sanchez.sergio.brownie.BrownieApp
import timber.log.Timber

class Agrociety: BrownieApp() {

    override fun onDebugConfig() {
        super.onDebugConfig()
        Timber.plant(Timber.DebugTree())
    }

}