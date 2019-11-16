package sanchez.sanchez.sergio.agrociety.ui.features.main.home.personalboard

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.PersonalBoardComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class PersonalBoardFragment: SupportFragment<PersonalBoardViewModel, Void>(PersonalBoardViewModel::class.java) {

    private val component: PersonalBoardComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getPersonalBoardComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_personal_board

    override fun onInject() {
        component.inject(this)
    }
}