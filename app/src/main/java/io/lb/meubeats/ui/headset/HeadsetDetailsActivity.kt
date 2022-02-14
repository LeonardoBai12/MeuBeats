package io.lb.meubeats.ui.headset

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.lb.meubeats.databinding.ActivityHeadsetDetailsBinding

class HeadsetDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeadsetDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeadsetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}