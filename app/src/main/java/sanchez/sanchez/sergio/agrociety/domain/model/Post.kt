package sanchez.sanchez.sergio.agrociety.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Post(
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String,
    val date: Date,
    val likesCount: Int,
    val commentsCount: Int,
    val author: User): Parcelable
