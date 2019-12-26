package sanchez.sanchez.sergio.agrociety.domain.model

import java.util.*

data class Comment(
    val id: String,
    val text: String,
    val date: Date = Date(),
    val author: User
)