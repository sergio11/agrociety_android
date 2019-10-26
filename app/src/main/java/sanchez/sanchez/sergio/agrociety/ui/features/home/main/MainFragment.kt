package sanchez.sanchez.sergio.agrociety.ui.features.home.main

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.MainComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class MainFragment: SupportFragment<MainViewModel, Void>(MainViewModel::class.java) {

    private val component: MainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getMainComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_main

    override fun onInject() { component.inject(this) }

}