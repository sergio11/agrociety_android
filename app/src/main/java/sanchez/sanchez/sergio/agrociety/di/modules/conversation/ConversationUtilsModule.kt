package sanchez.sanchez.sergio.agrociety.di.modules.conversation

import com.squareup.picasso.Picasso
import com.stfalcon.chatkit.commons.ImageLoader
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@Module
class ConversationUtilsModule {

    @Provides
    @PerFragment
    fun provideImageLoader(picasso: Picasso): ImageLoader =
        ImageLoader { imageView, url, payload ->
            picasso
                .load(url)
                .into(imageView)
        }
}