package sanchez.sanchez.sergio.agrociety.domain.model

import androidx.annotation.DrawableRes
import java.util.*

data class Publication(
    @DrawableRes val image: Int,
    val title: String,
    val date: Date,
    val likesCount: Int,
    val commentsCount: Int)