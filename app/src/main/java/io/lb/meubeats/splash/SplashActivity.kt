package io.lb.meubeats.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.lb.meubeats.databinding.ActivitySplashBinding
import io.lb.meubeats.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openActivityAccordingToUser()
    }

    private fun openActivityAccordingToUser() {
//        val i = if (auth.currentUser != null) {
//            Intent(this, MainActivity::class.java)
//        } else {
//            Intent(this, LoginActivity::class.java)
//        }

        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }
}