package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.SignupModule
import sanchez.sanchez.sergio.agrociety.ui.features.intro.signup.SignupFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        SignupModule::class ])
interface SignupComponent: FragmentComponent {

    fun inject(signupFragment: SignupFragment)
}