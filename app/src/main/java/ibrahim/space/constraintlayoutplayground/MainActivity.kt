package ibrahim.space.constraintlayoutplayground

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addActivity("Chains", Intent(this, ChainsActivity::class.java))
        addActivity("Barrier", Intent(this, BarrierActivity::class.java))
        addActivity("Groups", Intent(this, GroupActivity::class.java))
        addActivity("Profile Animation", Intent(this, ProfileActivity::class.java))
        addActivity("Login", Intent(this, LoginActivity::class.java))
        addActivity("Challenge", Intent(this, ChallengeActivity::class.java))
        addActivity("Spoiler", Intent(this, SpoilersActivity::class.java))
    }


    private fun addActivity(title: String, intent: Intent) {
        val view: TextView = layoutInflater.inflate(R.layout.title_view, rootView, false) as TextView
        view.text = title
        view.setOnClickListener {
            startActivity(intent)
        }
        rootView.addView(view)
    }
}