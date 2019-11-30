package sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.events_calendar_layout.view.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.listener.IGestureListener
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.adapter.CalendarAdapter
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.model.Day
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.model.Event
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.view.GestureDetectorContainer
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.eventscalendar.view.GestureDetectorScrollView
import java.util.*
import java.text.SimpleDateFormat

/**
 * Events Calendar
 */
class EventsCalendar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr),
    IGestureListener {

    private val TAG = "ACTIVITY_CALENDAR"


    private lateinit var mContext: Context
    private lateinit var mInflater: LayoutInflater
    private lateinit var mLayoutRoot: GestureDetectorContainer
    private lateinit var monthTitle: TextView
    private lateinit var yearTitle: TextView
    private lateinit var mTableHead: TableLayout
    private lateinit var mScrollViewBody: GestureDetectorScrollView
    private lateinit var mTableBody: TableLayout
    private lateinit var prevWeekBtn: View
    private lateinit var nextWeekBtn: View
    private lateinit var weekNumberTitle: TextView
    private lateinit var weekTitle: TextView
    private lateinit var weekGroup: View
    private lateinit var monthGroup: View
    private lateinit var currentMonth: TextView
    private lateinit var separatorSeparator: View

    private lateinit var mAdapter: CalendarAdapter
    private var mListener: CalendarListener? = null
    private var expanded = false
    private var mInitHeight = 0
    private val mHandler = Handler()
    private var mIsWaitingForUpdate = false
    private var mCurrentWeekIndex: Int = 0
    var selectedItem: Day? = null

    /**
     * Properties
     */

    var firstDayOfWeek =
        SUNDAY

    var isSelectToday =
        false
        set(isSelectToday) {
            field = isSelectToday
            if(field)
                selectToday()
        }

    var primaryColor = Color.WHITE
        set(primaryColor) {
            field = primaryColor
            mLayoutRoot.setBackgroundColor(this.primaryColor)
        }

    var selectedItemBackgroundDrawable = ContextCompat.getDrawable(context, R.drawable.circle_white_solid_background)
        set(selectedItemBackground) {
            field = selectedItemBackground
            redraw()
        }

    var selectedItemTextColor = Color.WHITE
        set(selectedItemTextColor) {
            field = selectedItemTextColor
            redraw()
        }

    var eventColor = Color.BLACK
        private set(eventColor) {
            field = eventColor
        }

    var mState =
        STATE_COLLAPSED

    private val suitableRowIndex: Int
        get() {
            return when {
                selectedItemPosition != -1 -> {
                    val view = mAdapter.getView(selectedItemPosition)
                    val row = view.parent as TableRow

                    mTableBody.indexOfChild(row)
                }
                todayItemPosition != -1 -> {
                    val view = mAdapter.getView(todayItemPosition)
                    val row = view.parent as TableRow

                    mTableBody.indexOfChild(row)
                }
                else -> 0
            }
        }

    val today: Day
        get() = Calendar.getInstance().let {
            val day = it.get(Calendar.DAY_OF_MONTH)
            val month = it.get(Calendar.MONTH)
            val year = it.get(Calendar.YEAR)
            return Day(
                year,
                month,
                day
            )
        }


    val year: Int
        get() = mAdapter.calendar.get(Calendar.YEAR)


    val month: Int
        get() = mAdapter.calendar.get(Calendar.MONTH) + 1

    val selectedDay: Day
        get() {
                return if (selectedItem != null)
                    Day(
                        selectedItem!!.year,
                        selectedItem!!.month + 1,
                        selectedItem!!.day
                    )
                else {
                    today
                }
        }

    val selectedItemPosition: Int
        get() {
            var position = -1
            for (i in 0 until mAdapter.count) {
                val day = mAdapter.getItem(i)
                if (isSelectedDay(day)) {
                    position = i
                    break
                }
            }
            return position
        }

    val todayItemPosition: Int
        get() {
            var position = -1
            for (i in 0 until mAdapter.count) {
                val day = mAdapter.getItem(i)
                if (isToday(day)) {
                    position = i
                    break
                }
            }
            return position
        }


    init {

        init(context)

        context.theme.obtainStyledAttributes(
            attrs, R.styleable.EventsCalendar, defStyleAttr, 0
        ).also {
            setAttributes(it)
            it.recycle()
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        mInitHeight = mTableBody.measuredHeight

        if (mIsWaitingForUpdate) {
            redraw()
            collapseTo(mCurrentWeekIndex)
            mIsWaitingForUpdate = false
            if (mListener != null) {
                mListener!!.onDataUpdate()
            }
        }
    }


    fun addEventTag(numYear: Int, numMonth: Int, numDay: Int) {
        mAdapter.addEvent(
            Event(
                numYear,
                numMonth,
                numDay,
                eventColor
            )
        )
    }

    fun addEventTag(numYear: Int, numMonth: Int, numDay: Int, color: Int) {
        mAdapter.addEvent(
            Event(
                numYear,
                numMonth,
                numDay,
                color
            )
        )
    }

    fun removeEventTag(numYear: Int, numMonth: Int, numDay: Int) {
        mAdapter.removeEvent(
            Event(
                numYear,
                numMonth,
                numDay,
                eventColor
            )
        )
    }

    fun prevMonth() {
        val cal = mAdapter.calendar
        if (cal.get(Calendar.MONTH) == cal.getActualMinimum(Calendar.MONTH)) {
            cal.set(cal.get(Calendar.YEAR) - 1, cal.getActualMaximum(Calendar.MONTH), 1)
        } else {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1)
        }
        mListener?.onMonthChange()
        Log.d(TAG, "prevMonth called")
        reload()

    }

    fun nextMonth() {
        val cal = mAdapter.calendar
        if (cal.get(Calendar.MONTH) == cal.getActualMaximum(Calendar.MONTH)) {
            cal.set(cal.get(Calendar.YEAR) + 1, cal.getActualMinimum(Calendar.MONTH), 1)
        } else {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1)
        }
        mListener?.onMonthChange()
        Log.d(TAG, "nextMonth called")
        reload()

    }

    fun goToDaySelected() {
        mAdapter.calendar.apply {
            set(selectedDay.year, selectedDay.month - 1, selectedDay.day)
        }
        Log.d(TAG, "goToDaySelected called")
        reload()
    }


    fun prevWeek() {
        if (mCurrentWeekIndex - 1 < 0) {
            mCurrentWeekIndex = -1
            prevMonth()
        } else {
            mCurrentWeekIndex--
            collapseTo(mCurrentWeekIndex)
        }
    }

    fun nextWeek() {
        if (mCurrentWeekIndex + 1 >= mTableBody.childCount) {
            mCurrentWeekIndex = 0
            nextMonth()
        } else {
            mCurrentWeekIndex++
            collapseTo(mCurrentWeekIndex)
        }
    }

    fun collapse(duration: Int = DEFAULT_ANIMATION_DURATION) {

        if (mState == STATE_EXPANDED) {
            setState(STATE_PROCESSING)

            val index = suitableRowIndex
            mCurrentWeekIndex = index

            val currentHeight = mInitHeight
            val targetHeight = mTableBody.getChildAt(index).measuredHeight
            var tempHeight = 0
            for (i in 0 until index) {
                tempHeight += mTableBody.getChildAt(i).measuredHeight
            }
            val topHeight = tempHeight

            val anim = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation) {

                    mScrollViewBody.layoutParams.height = if (interpolatedTime == 1f)
                        targetHeight
                    else
                        currentHeight - ((currentHeight - targetHeight) * interpolatedTime).toInt()
                    mScrollViewBody.requestLayout()

                    if (mScrollViewBody.measuredHeight < topHeight + targetHeight) {
                        val position = topHeight + targetHeight - mScrollViewBody.measuredHeight
                        mScrollViewBody.smoothScrollTo(0, position)
                    }

                    if (interpolatedTime == 1f) {
                        setState(STATE_COLLAPSED)
                        prevWeekBtn.isClickable = true
                        nextWeekBtn.isClickable = true
                    }
                }
            }
            anim.duration = duration.toLong()
            startAnimation(anim)
        }

    }

    fun expand(duration: Int = DEFAULT_ANIMATION_DURATION) {
        if (mState == STATE_COLLAPSED) {
            setState(STATE_PROCESSING)

            val currentHeight = mScrollViewBody.measuredHeight
            val targetHeight = mInitHeight

            val anim = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation) {

                    mScrollViewBody.layoutParams.height = if (interpolatedTime == 1f)
                        LayoutParams.WRAP_CONTENT
                    else
                        currentHeight - ((currentHeight - targetHeight) * interpolatedTime).toInt()
                    mScrollViewBody.requestLayout()

                    if (interpolatedTime == 1f) {
                        setState(STATE_EXPANDED)

                        prevWeekBtn.isClickable = true
                        nextWeekBtn.isClickable = true
                    }
                }
            }
            anim.duration = duration.toLong()
            startAnimation(anim)
        }
    }

    fun selectToday() {
        select(today)
    }

    fun select(day: Day) {
        selectedItem =
            Day(
                day.year,
                day.month,
                day.day
            )


        Log.d(TAG, "select called")
        redraw()

        showDaySelected()

        if (mListener != null) {
            mListener!!.onDaySelect()
        }
    }

    fun setStateWithUpdateUI(state: Int) {
        setState(state)

        if (state != state) {
            mIsWaitingForUpdate = true
            requestLayout()
        }
    }

    // callback
    fun setCalendarListener(listener: CalendarListener) {
        mListener = listener
    }


    fun reload() {

        mAdapter.refresh()

        currentMonth.text = SimpleDateFormat("MMM yyyy").format(mAdapter.calendar.time)

        mTableHead.removeAllViews()
        mTableBody.removeAllViews()


        var rowCurrent: TableRow

        rowCurrent = TableRow(mContext)
        rowCurrent.layoutParams = TableLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        drawCalendarWeekHeader(rowCurrent)

        // set day view
        for (i in 0 until mAdapter.count) {

            if (i % 7 == 0) {
                rowCurrent = TableRow(mContext)
                rowCurrent.layoutParams = TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                mTableBody.addView(rowCurrent)
            }

            val view = mAdapter.getView(i)
            view.layoutParams = TableRow.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )


            view.setOnClickListener { v -> onItemClicked(v, mAdapter.getItem(i)) }
            rowCurrent.addView(view)
        }



        mIsWaitingForUpdate = true

    }




    /**
     *
     * Private Methods
     */


    private fun init(context: Context) {

        mContext = context
        mInflater = LayoutInflater.from(mContext)

        val rootView =
            mInflater.inflate(R.layout.events_calendar_layout, this, true)

        // init UI
        mLayoutRoot = rootView.findViewById(R.id.layout_root)
        monthTitle = rootView.findViewById(R.id.monthTitle)
        yearTitle = rootView.findViewById(R.id.yearTitle)
        prevWeekBtn = rootView.findViewById(R.id.prevWeek)
        nextWeekBtn = rootView.findViewById(R.id.nextWeek)
        weekNumberTitle = rootView.findViewById(R.id.weekNumberTitle)
        weekTitle = rootView.findViewById(R.id.weekTitle)
        mTableHead = rootView.findViewById(R.id.table_head)
        mScrollViewBody = rootView.findViewById(R.id.scroll_view_body)
        mTableBody = rootView.findViewById(R.id.table_body)
        weekGroup = rootView.findViewById(R.id.weekGroup)
        monthGroup = rootView.findViewById(R.id.monthGroup)
        currentMonth = rootView.findViewById(R.id.currentMonth)
        separatorSeparator = rootView.findViewById(R.id.separator)

        // Init Adapter
        mAdapter =
            CalendarAdapter(
                context,
                Calendar.getInstance()
            )

        mAdapter.setFirstDayOfWeek(firstDayOfWeek)

        mLayoutRoot.gestureListener = this
        mScrollViewBody.gestureListener = this

        reload()

        // init week
        mCurrentWeekIndex = suitableRowIndex

        prevWeekBtn.setOnClickListener { prevWeek() }
        nextWeekBtn.setOnClickListener { nextWeek() }


        dayTitle.setOnClickListener {
            goToDaySelected()
        }

        monthTitle.setOnClickListener {
            goToDaySelected()
        }

        yearTitle.setOnClickListener {
            goToDaySelected()
        }

        weekTitle.setOnClickListener {
            goToDaySelected()
        }

        separatorSeparator.setOnTouchListener { _, _ ->
            if(mState == STATE_EXPANDED)
                collapse()
            else
                expand()

            true
        }

        weekNumberTitle.setOnClickListener { goToDaySelected() }


    }

    /**
     * redraw all views of week
     */
    private fun redraw() {

        for (i in 0 until mAdapter.count) {
            val day = mAdapter.getItem(i)
            val view = mAdapter.getView(i)
            val txtDay = view.findViewById<View>(R.id.txt_day) as TextView
            val imgEventTag = view.findViewById<View>(R.id.img_event_tag) as ImageView
            // set the selected item
            if (isSelectedDay(day)) {
                txtDay.background = selectedItemBackgroundDrawable
                txtDay.setTextColor(selectedItemTextColor)
                imgEventTag.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
            } else {
                txtDay.setBackgroundResource(0)
                txtDay.setTextColor(ContextCompat.getColor(context, R.color.white))
                imgEventTag.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_ATOP)
            }
        }
    }

    private fun setAttributes(attrs: TypedArray) {
        firstDayOfWeek = attrs.getInt(R.styleable.EventsCalendar_firstDayOfWeek, firstDayOfWeek)
        setState(attrs.getInt(R.styleable.EventsCalendar_state, mState))
        eventColor = attrs.getColor(R.styleable.EventsCalendar_eventColor, eventColor)
        primaryColor = attrs.getColor(R.styleable.EventsCalendar_primaryColor, primaryColor)
        isSelectToday = attrs.getBoolean(R.styleable.EventsCalendar_selectToday, isSelectToday)
        selectedItemTextColor = attrs.getColor(
            R.styleable.EventsCalendar_selectedItem_textColor, selectedItemTextColor
        )
        attrs.getDrawable(R.styleable.EventsCalendar_selectedItem_background)?.let {
            selectedItemBackgroundDrawable = it
        }
    }

    private fun collapseTo(index: Int) {
        var index = index
        if (mState == STATE_COLLAPSED) {

            if (index == -1) {
                index = mTableBody.childCount - 1
            }
            mCurrentWeekIndex = index

            val targetHeight = mTableBody.getChildAt(index).measuredHeight
            var tempHeight = 0
            for (i in 0 until index) {
                tempHeight += mTableBody.getChildAt(i).measuredHeight
            }
            val topHeight = tempHeight

            mScrollViewBody.layoutParams.height = targetHeight
            mScrollViewBody.requestLayout()

            mHandler.post { mScrollViewBody.smoothScrollTo(0, topHeight) }


            if (mListener != null) {
                mListener!!.onWeekChange(mCurrentWeekIndex)
            }
        }
    }

    private fun setState(state: Int) {
        this.mState = state

        when(mState) {
            STATE_EXPANDED -> configureExpanded()
            STATE_COLLAPSED -> configureCollapsed()
        }
    }

    private fun configureExpanded() {
        weekGroup.visibility = View.INVISIBLE
        monthGroup.visibility = View.VISIBLE
        expanded = true
    }

    private fun configureCollapsed() {
        weekGroup.visibility = View.VISIBLE
        monthGroup.visibility = View.INVISIBLE
        expanded = false
    }

    private fun showDaySelected() {
        Calendar.getInstance().apply {
            set(selectedDay.year, selectedDay.month - 1, selectedDay.day)
        }.also {
            monthTitle.text = it.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US)
            dayTitle.text = it.get(Calendar.DAY_OF_MONTH).toString()
            yearTitle.text = it.get(Calendar.YEAR).toString()
            weekNumberTitle.text = it.get(Calendar.WEEK_OF_YEAR).toString()
        }
    }

    private fun isSelectedDay(day: Day?): Boolean {
        return (day != null
                && selectedItem != null
                && day.year == selectedItem!!.year
                && day.month == selectedItem!!.month
                && day.day == selectedItem!!.day)
    }

    private fun isToday(day: Day?): Boolean {
        val todayCal = Calendar.getInstance()
        return (day != null
                && day.year == todayCal.get(Calendar.YEAR)
                && day.month == todayCal.get(Calendar.MONTH)
                && day.day == todayCal.get(Calendar.DAY_OF_MONTH))
    }


    private fun drawCalendarWeekHeader(rowCurrent: TableRow) {

        // set day of week
        val dayOfWeekIds = intArrayOf(
            R.string.sunday,
            R.string.monday,
            R.string.tuesday,
            R.string.wednesday,
            R.string.thursday,
            R.string.friday,
            R.string.saturday
        )

        for (i in 0..6) {
            val view = mInflater.inflate(R.layout.events_calendar_day_of_week_layout, null)
            val txtDayOfWeek = view.findViewById<View>(R.id.txt_day_of_week) as TextView
            txtDayOfWeek.setText(dayOfWeekIds[(i + firstDayOfWeek) % 7])
            view.layoutParams = TableRow.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
            rowCurrent.addView(view)
        }
        mTableHead.addView(rowCurrent)
    }


    private fun onItemClicked(view: View, day: Day) {

        select(day)

        val cal = mAdapter.calendar

        val newYear = day.year
        val newMonth = day.month
        val oldYear = cal.get(Calendar.YEAR)
        val oldMonth = cal.get(Calendar.MONTH)
        if (newMonth != oldMonth) {
            cal.set(day.year, day.month, 1)

            if (newYear > oldYear || newMonth > oldMonth) {
                mCurrentWeekIndex = 0
            }
            if (newYear < oldYear || newMonth < oldMonth) {
                mCurrentWeekIndex = -1
            }


            mListener?.onMonthChange()
            Log.d(TAG, "reload called")
            reload()
        }

        mListener?.onItemClick(view)
    }

    override fun onSwipeRight() {
        Log.d(TAG, "onSwipeRight")
        if(mState == STATE_EXPANDED)
            prevMonth()
        else
            prevWeek()
    }

    override fun onSwipeLeft() {
        Log.d(TAG, "onSwipeLeft")
        if(mState == STATE_EXPANDED)
            nextMonth()
        else
            nextWeek()
    }

    override fun onSwipeTop() {
        Log.d(TAG, "onSwipeTop")
        if(mState == STATE_EXPANDED)
            collapse()
    }

    override fun onSwipeBottom() {
        Log.d(TAG, "onSwipeBottom")
        if(mState == STATE_COLLAPSED)
            expand()

    }

    interface CalendarListener {

        // triggered when a day is selected programmatically or clicked by user.
        fun onDaySelect()

        // triggered only when the views of day on calendar are clicked by user.
        fun onItemClick(v: View)

        // triggered when the data of calendar are updated by changing month or adding events.
        fun onDataUpdate()

        // triggered when the month are changed.
        fun onMonthChange()

        // triggered when the week position are changed.
        fun onWeekChange(position: Int)
    }


    companion object {

        /**
         * Constants
         */
        const val SUNDAY = 0
        const val MONDAY = 1
        const val TUESDAY = 2
        const val WEDNESDAY = 3
        const val THURSDAY = 4
        const val FRIDAY = 5
        const val SATURDAY = 6

        /**
         * Calendar State
         */
        const val STATE_EXPANDED = 0
        const val STATE_COLLAPSED = 1
        const val STATE_PROCESSING = 2
        const val SWIPE_THRESHOLD = 100
        const val SWIPE_VELOCITY_THRESHOLD = 100
        const val DEFAULT_ANIMATION_DURATION = 200
    }


}

