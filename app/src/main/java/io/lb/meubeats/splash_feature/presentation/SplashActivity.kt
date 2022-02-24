package io.lb.meubeats.splash_feature.presentation

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.databinding.ActivitySplashBinding
import io.lb.meubeats.headset_feature.presentation.headset.HeadsetActivity
import io.lb.meubeats.not_connected_feature.presentation.NotConnectedActivity
import io.lb.meubeats.user_feature.presentation.login.LoginActivity
import io.lb.meubeats.utils.NetworkHelper
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {
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
            Intent(this, HeadsetActivity::class.java)
        } else {
            Intent(this, LoginActivity::class.java)
        }
        startActivity(i)
        finish()
    }
}