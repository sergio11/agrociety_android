package sanchez.sanchez.sergio.agrociety.di.modules.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.agrociety.ui.features.intro.location.SetLocationViewModel
import sanchez.sanchez.sergio.agrociety.ui.features.splash.SplashViewModel
import sanchez.sanchez.sergio.brownie.di.modules.ViewModelModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment
import sanchez.sanchez.sergio.brownie.di.viewmodel.ViewModelKey

@Module(includes = [ ViewModelModule::class ])
abstract class SplashModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(splashViewModel: SplashViewModel): ViewModel

}