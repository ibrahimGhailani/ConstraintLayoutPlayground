package ibrahim.space.constraintlayoutplayground

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.acivity_barrier.*


class BarrierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_barrier)

        val barrierConstraintSet = ConstraintSet()
        barrierConstraintSet.clone(this, R.layout.acivity_barrier)

        imageView.setOnTouchListener({ _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    applyTransition(barrierConstraintSet, {
                        barrierConstraintSet.setVisibility(R.id.imageView, View.GONE)
                        barrierConstraintSet.setVisibility(R.id.instructionTextView, View.GONE)
                    })
                }
                else -> {
                    applyTransition(barrierConstraintSet, {
                        barrierConstraintSet.setVisibility(R.id.imageView, View.VISIBLE)
                        barrierConstraintSet.setVisibility(R.id.instructionTextView, View.VISIBLE)
                    })
                }
            }
            true
        })
    }

    private fun applyTransition(constraintSet: ConstraintSet, newConstraints: () -> Unit) {
        val transition = AutoTransition()
        transition.duration = 300
        transition.interpolator = AccelerateDecelerateInterpolator()
        TransitionManager.beginDelayedTransition(barrierRootView, transition)
        newConstraints()
        constraintSet.applyTo(barrierRootView)
    }
}