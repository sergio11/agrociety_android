package sanchez.sanchez.sergio.agrociety.domain.model

import android.net.Uri

data class User (
    var displayName: String,
    var email: String,
    var photoUrl: Uri?
)