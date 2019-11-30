package sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.model


data class Event (
    val year: Int = 0,
    val month: Int = 0,
    val day: Int = 0,
    val color: Int
) {
    override fun equals(other: Any?): Boolean =
        if(other !is Event)
            false
        else year == other.year && month == other.month + 1
                && day == other.day
}
