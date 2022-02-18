package io.lb.meubeats.headset_feature.presentation.headset_details

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityHeadsetDetailsBinding
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.presentation.headset.HeadsetViewModel
import io.lb.meubeats.utils.GeneralConstants
import timber.log.Timber
import javax.inject.Inject

class HeadsetDetailsActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityHeadsetDetailsBinding
    private var headset: Headset? = null
    private var id = 0

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HeadsetViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeadsetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupActionBar()
        setupViews()
        setupBuyButton()
    }

    private fun setupBuyButton() {
        binding.btBuy.setOnClickListener {
            if (headset == null) {
                return@setOnClickListener
            }

            viewModel.insertHeadset(id, headset!!) { isSuccessful, exception ->
                if (isSuccessful) {
                    finish()
                } else {
                    Timber.e(exception)
                    toastMakeText("Falha ao salvar produto. $exception")
                }
            }
        }
    }

    private fun toastMakeText(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun setupViews() {
        headset = intent.getSerializableExtra(GeneralConstants.HEADSET) as Headset?

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

    private fun setupViewModel() {
        viewModel.loadHeadsetsFromFirebaseListener { headsets ->
            id = headsets.size
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }


    private fun setupActionBar() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setBackgroundDrawable(
            AppCompatResources.getDrawable(this, R.color.primary_dark)
        )
        supportActionBar?.elevation = 0.0F
    }
}