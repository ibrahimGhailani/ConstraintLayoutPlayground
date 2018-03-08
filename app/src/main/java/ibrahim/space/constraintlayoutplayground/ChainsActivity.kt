package ibrahim.space.constraintlayoutplayground

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_chain.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class ChainsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chain)

        val queue = LinkedList<Int>()
        with(queue) {
            add(ConstraintSet.CHAIN_PACKED)
            add(ConstraintSet.CHAIN_SPREAD)
            add(ConstraintSet.CHAIN_SPREAD_INSIDE)
        }

        chainRootView.setOnClickListener {
            queue.add(queue.pop().also {
                val transition = ChangeBounds()
                with(transition) {
                    duration = 300
                    interpolator = OvershootInterpolator()
                }

                TransitionManager.beginDelayedTransition(chainRootView, transition)

                val constraintSet = ConstraintSet()
                constraintSet.clone(chainRootView)
                constraintSet.setHorizontalChainStyle(R.id.imageView, it)
                constraintSet.applyTo(chainRootView)
            })
        }
    }
}