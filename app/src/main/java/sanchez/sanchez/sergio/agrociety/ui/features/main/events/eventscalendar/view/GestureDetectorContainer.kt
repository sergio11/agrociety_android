package sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.view

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.FrameLayout
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener.IGestureListener
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener.SimpleGestureListenerImpl

class GestureDetectorContainer @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null
) : FrameLayout(context, attr), SimpleGestureListenerImpl.IGestureActions {

    private val gestureDetector: GestureDetector = GestureDetector(context,
        SimpleGestureListenerImpl(
            catchAllEvents = true,
            gestureListener = this
        )
    )

    var gestureListener: IGestureListener? = null

    override fun onTouchEvent(ev: MotionEvent): Boolean =
        gestureDetector.onTouchEvent(ev)

    override fun onSwipeRight() {
        gestureListener?.onSwipeRight()
    }

    override fun onSwipeLeft() {
        gestureListener?.onSwipeLeft()
    }

    override fun onSwipeBottom() {
        gestureListener?.onSwipeBottom()
    }

    override fun onSwipeTop() {
        gestureListener?.onSwipeTop()
    }

}