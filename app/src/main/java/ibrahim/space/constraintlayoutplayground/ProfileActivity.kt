package ibrahim.space.constraintlayoutplayground

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.MotionEvent
import kotlinx.android.synthetic.main.acivity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_profile)

        val showImage = ConstraintSet()
        showImage.clone(this, R.layout.activity_profile_image_view)

        val showProfile = ConstraintSet().also { it.clone(this, R.layout.acivity_profile) }

        profileImageView.setOnTouchListener { _, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    TransitionManager.beginDelayedTransition(profileRootView)
                    showImage.applyTo(profileRootView)
                }
                else -> {
                    TransitionManager.beginDelayedTransition(profileRootView)
                    showProfile.applyTo(profileRootView)
                }
            }
            true
        }
    }
}

