package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.LoginModelModule
import sanchez.sanchez.sergio.agrociety.ui.features.intro.login.LoginFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        LoginModelModule::class ])
interface LoginComponent: FragmentComponent {

    fun inject(loginFragment: LoginFragment)
}