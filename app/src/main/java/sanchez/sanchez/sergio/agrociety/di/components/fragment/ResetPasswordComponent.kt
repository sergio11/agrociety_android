package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.ResetPasswordModule
import sanchez.sanchez.sergio.agrociety.ui.features.resetpassword.ResetPasswordFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        ResetPasswordModule::class ])
interface ResetPasswordComponent: FragmentComponent {

    fun inject(resetPasswordFragment: ResetPasswordFragment)
}