package sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener

import android.view.GestureDetector
import android.view.MotionEvent
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.widget.EventsCalendar.Companion.SWIPE_THRESHOLD
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.widget.EventsCalendar.Companion.SWIPE_VELOCITY_THRESHOLD
import kotlin.math.abs

class SimpleGestureListenerImpl(
    private val catchAllEvents: Boolean = false,
    private val gestureListener: IGestureActions
) : GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent): Boolean = catchAllEvents

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        var result = false
        try {
            val diffY = e2.y - e1.y
            val diffX = e2.x - e1.x
            if (abs(diffX) > abs(diffY)) {
                if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        gestureListener.onSwipeRight()
                    } else {
                        gestureListener.onSwipeLeft()
                    }
                    result = true
                }
            } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    gestureListener.onSwipeBottom()
                } else {
                    gestureListener.onSwipeTop()
                }
                result = true
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return result
    }


    interface IGestureActions {
        fun onSwipeRight()
        fun onSwipeLeft()
        fun onSwipeBottom()
        fun onSwipeTop()
    }
}