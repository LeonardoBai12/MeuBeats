package io.lb.meubeats.not_connected_feature.presentation

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.databinding.ActivityNotConnectedBinding
import io.lb.meubeats.splash_feature.presentation.SplashActivity

class NotConnectedActivity: DaggerAppCompatActivity() {
    private lateinit var binding: ActivityNotConnectedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotConnectedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.included.btTryAgain.setOnClickListener {
            openSplashActivity()
        }
    }

    private fun openSplashActivity() {
        val i = Intent(this, SplashActivity::class.java)
        startActivity(i)
        finish()
    }
}