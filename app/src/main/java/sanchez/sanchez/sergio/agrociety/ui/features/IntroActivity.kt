package sanchez.sanchez.sergio.agrociety.ui.features

import android.os.Bundle
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.agrociety.di.components.activity.ApplicationActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory

class IntroActivity : SupportActivity() {

    private val activityComponent: ApplicationActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getAppActivityComponent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
    }

    override fun layoutId(): Int = R.layout.activity_intro

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() { activityComponent.inject(this) }
}
