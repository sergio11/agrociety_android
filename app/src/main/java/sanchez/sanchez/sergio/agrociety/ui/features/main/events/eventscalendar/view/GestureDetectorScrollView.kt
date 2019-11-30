package sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.view

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ScrollView
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener.IGestureListener
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener.SimpleGestureListenerImpl

class GestureDetectorScrollView @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null
) : ScrollView(context, attr), SimpleGestureListenerImpl.IGestureActions {

    private val gestureDetector: GestureDetector =
        GestureDetector(context,
            SimpleGestureListenerImpl(
                gestureListener = this
            )
        )

    var gestureListener: IGestureListener? = null

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean = gestureDetector.onTouchEvent(ev)

    override fun onTouchEvent(ev: MotionEvent): Boolean = gestureDetector.onTouchEvent(ev)

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