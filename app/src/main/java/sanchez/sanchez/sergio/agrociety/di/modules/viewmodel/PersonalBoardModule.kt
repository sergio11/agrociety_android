package sanchez.sanchez.sergio.agrociety.di.modules.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.personalboard.PersonalBoardViewModel
import sanchez.sanchez.sergio.brownie.di.modules.ViewModelModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment
import sanchez.sanchez.sergio.brownie.di.viewmodel.ViewModelKey

@Module(includes = [ ViewModelModule::class ])
abstract class PersonalBoardModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(PersonalBoardViewModel::class)
    abstract fun bindsPersonalBoardViewModel(personalBoardViewModel: PersonalBoardViewModel): ViewModel

}