package io.lb.meubeats.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import io.lb.meubeats.databinding.ActivitySplashBinding
import io.lb.meubeats.ui.login.LoginActivity
import io.lb.meubeats.ui.main.MainActivity
import io.lb.meubeats.ui.not_connected.NotConnectedActivity
import io.lb.meubeats.utils.NetworkHelper
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openActivityAccordingToUser()
    }

    private fun openActivityAccordingToUser() {
        val i = if (!NetworkHelper.isOnline(this)) {
            Intent(this, NotConnectedActivity::class.java)
        } else if (auth.currentUser != null) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, LoginActivity::class.java)
        }
        startActivity(i)
        finish()
    }
}