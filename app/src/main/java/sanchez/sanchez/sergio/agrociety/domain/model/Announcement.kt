package sanchez.sanchez.sergio.agrociety.domain.model

import androidx.annotation.DrawableRes
import java.util.*

data class Announcement(
    val id: String,
    val title: String,
    val date: Date,
    @DrawableRes val imageRes: Int
)