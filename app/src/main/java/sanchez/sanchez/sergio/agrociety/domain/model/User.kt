package sanchez.sanchez.sergio.agrociety.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var id: String,
    var displayName: String,
    var email: String,
    var photoUrl: String? = null,
    var follow: Int = 0,
    var followers: Int = 0,
    @DrawableRes val background: Int
) : Parcelable