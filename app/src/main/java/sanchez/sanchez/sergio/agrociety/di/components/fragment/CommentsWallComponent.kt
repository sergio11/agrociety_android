package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.CommentsWallModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail.comments.CommentsWallFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        CommentsWallModule::class ])
interface CommentsWallComponent: FragmentComponent {

    fun inject(commentsWallFragment: CommentsWallFragment)
}