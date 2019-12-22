package sanchez.sanchez.sergio.agrociety.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SearchCategory(
    val id: String,
    val title: String
) : Parcelable