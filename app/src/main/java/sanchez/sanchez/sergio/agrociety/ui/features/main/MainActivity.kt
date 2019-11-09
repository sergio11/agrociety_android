package sanchez.sanchez.sergio.agrociety.ui.features.main

import android.app.Activity
import androidx.navigation.ActivityNavigator
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.activity.MainActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.createDestination
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity


class MainActivity: SupportActivity() {

    private val activityComponent: MainActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getMainActivityComponent(this)
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() { activityComponent.inject(this) }


    /** COMPANION OBJECT **/

    companion object {

        @JvmStatic
        fun createDestination(activity: Activity): ActivityNavigator.Destination =
            activity.createDestination(MainActivity::class.java)

    }


}