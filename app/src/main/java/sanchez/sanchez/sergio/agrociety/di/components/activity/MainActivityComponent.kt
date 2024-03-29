package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.*
import sanchez.sanchez.sergio.agrociety.ui.features.main.MainActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
])
interface MainActivityComponent: ActivityComponent {

    fun inject(activity: MainActivity)

    fun homeComponent(): HomeComponent
    fun newsBoardComponent(): NewsBoardComponent
    fun eventsComponent(): EventsComponent
    fun personalBoardComponent(): PersonalBoardComponent
    fun detailComponent(): DetailComponent
    fun userProfileComponent(): UserProfileComponent
    fun userPostBoardComponent(): UserPostBoardComponent
    fun lastAnnouncementsComponent(): LastAnnouncementsComponent
    fun contactListComponent(): ContactListComponent
    fun userSettingsComponent(): UserSettingsComponent
    fun searchComponent(): SearchComponent
    fun userDetailComponent(): UserDetailComponent
    fun commentsWallComponent(): CommentsWallComponent
}