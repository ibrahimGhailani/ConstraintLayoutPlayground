package ibrahim.space.constraintlayoutplayground

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeTransform
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logoImageView.setOnClickListener {
            val transition = ChangeTransform()
            with(transition) {
                duration = 600
                interpolator = OvershootInterpolator()
            }

            TransitionManager.beginDelayedTransition(loginRootView, transition)

            val constraintSet = ConstraintSet()
            with(constraintSet) {
                clone(this@LoginActivity, R.layout.activity_login)
                setTransformPivotX(R.id.logoImageView, logoImageView.width / 2f)
                setScaleY(R.id.logoImageView, 1.5f)
                setScaleX(R.id.logoImageView, 1.5f)
                applyTo(loginRootView)

            }
        }
    }
}