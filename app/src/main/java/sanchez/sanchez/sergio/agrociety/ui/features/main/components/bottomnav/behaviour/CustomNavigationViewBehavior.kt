package sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.behaviour

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar

class CustomNavigationViewBehavior<V: View>(context: Context?, attrs: AttributeSet?) :
        CoordinatorLayout.Behavior<V>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        return dependency is Snackbar.SnackbarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        val translationY = dependency.translationY - dependency.height
        child.translationY = if(translationY > 0) translationY else 0.0f
        return true
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, nestedScrollAxes: Int, type: Int): Boolean {
        // Ensure we react to vertical scrolling
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)

        if(dyConsumed > 0)
            child.animate()
                .translationY(child.height.toFloat())
                .setDuration(150)
                .start()
        else if (dyConsumed < 0)
            child.animate()
                    .translationY(0.0f)
                    .setDuration(150)
                    .start()
    }
}