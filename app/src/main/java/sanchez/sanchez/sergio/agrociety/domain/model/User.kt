package sanchez.sanchez.sergio.agrociety.domain.model

import androidx.annotation.DrawableRes

data class User (
    var displayName: String,
    var email: String,
    var photoUrl: String? = null,
    @DrawableRes val background: Int
)