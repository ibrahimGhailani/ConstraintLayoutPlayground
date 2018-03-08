package ibrahim.space.constraintlayoutplayground

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_spoiler.*

class SpoilersActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spoiler)


        spoilerView.setOnLongClickListener {
            TransitionManager.beginDelayedTransition(spoilerRootView)
            val showSpoiler = ConstraintSet()
            with(showSpoiler) {
                clone(this@SpoilersActivity, R.layout.activity_spoiler_show)
                applyTo(spoilerRootView)
            }

            true
        }
    }
}