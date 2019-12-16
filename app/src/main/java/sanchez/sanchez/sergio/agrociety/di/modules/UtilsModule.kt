package sanchez.sanchez.sergio.agrociety.di.modules

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.brownie.di.scopes.PerApplication
import sanchez.sanchez.sergio.brownie.utils.SupportImagePicker
import timber.log.Timber

@Module
class UtilsModule {

    @Provides
    @PerApplication
    fun providePicasso(context: Context): Picasso =
        Picasso.Builder(context).apply {
            listener { picasso, uri, exception ->
                Timber.d(exception)
            }
        }.build()

    @Provides
    @PerApplication
    fun provideSupportImagePicker(context: Context): SupportImagePicker =
        SupportImagePicker(context)

}