package sanchez.sanchez.sergio.agrociety.ui.features.main.home

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.HomeComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class HomeFragment: SupportFragment<HomeViewModel, Void>(HomeViewModel::class.java) {

    private val component: HomeComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getHomeComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun onInject() { component.inject(this) }

}