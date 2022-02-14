package io.lb.meubeats.ui.headset

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityHeadsetDetailsBinding
import io.lb.meubeats.model.headset.Headset

class HeadsetDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeadsetDetailsBinding
    private var headset: Headset? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeadsetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()
        setupViews()
    }

    private fun setupViews() {
        headset = intent.getSerializableExtra("HEADSET") as Headset?

        headset?.let {
            binding.included.tvTitle.text = it.name
            binding.includedTexts.tvHeadsetConnection.text = it.connection
            binding.includedTexts.tvHeadsetCompatibility.text = it.compatibility
            binding.includedTexts.tvHeadsetPowerSupply.text = it.powerSupply
            binding.includedTexts.tvHeadsetAutonomy.text = it.autonomy.toString()
            binding.includedTexts.tvHeadsetHeight.text = it.height.toString()
            binding.includedTexts.tvHeadsetSoundCapture.text = it.soundCapture.toString()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }


    private fun setupActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setBackgroundDrawable(
            AppCompatResources.getDrawable(this, R.color.primary_dark)
        )
        supportActionBar?.elevation = 0.0F
    }
}