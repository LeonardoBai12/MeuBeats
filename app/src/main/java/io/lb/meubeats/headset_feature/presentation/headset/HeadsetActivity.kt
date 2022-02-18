package io.lb.meubeats.headset_feature.presentation.headset

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityMainBinding
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.presentation.headset_details.HeadsetDetailsActivity
import io.lb.meubeats.headset_feature.presentation.headset_details.HeadsetViewModel
import io.lb.meubeats.utils.GeneralConstants
import timber.log.Timber
import javax.inject.Inject

class HeadsetActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val headsetAdapter = HeadsetAdapter()
    private var id = 0

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HeadsetViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupActionBar()
        setupDetailsButtonListener()
        setupAddButtonListener()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.loadHeadsetsFromApi().observe(this) {
            updateHeadsets(it)
        }

        viewModel.loadHeadsetsFromFirebaseListener { headsets ->
            id = headsets.size
        }

        viewModel.selectedHeadset.observe(this) {
            binding.included.btHeadsetDetails.isEnabled = true
            binding.included.btAddHeadset.apply {
                text = getString(R.string.add)
                isEnabled = true
            }
        }
    }

    private fun setupAddButtonListener() {
        binding.included.btAddHeadset.setOnClickListener {
            val headset = viewModel.selectedHeadset.value ?: return@setOnClickListener
            viewModel.loadHeadsetsFromFirebase()

            viewModel.insertHeadset(id, headset) { isSuccessful, exception ->
                if (isSuccessful) {
                    toaskHeadsetAddSuccess()
                } else {
                    Timber.e(exception)
                }
            }
        }
    }

    private fun toaskHeadsetAddSuccess() {
        Toast.makeText(
            this,
            "Produto adicionado com sucesso!",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun setupDetailsButtonListener() {
        binding.included.btHeadsetDetails.setOnClickListener {
            val i = Intent(this, HeadsetDetailsActivity::class.java)
            val bundle = Bundle()

            bundle.putSerializable(GeneralConstants.HEADSET, viewModel.selectedHeadset.value)
            i.putExtras(bundle)

            startActivity(i)
        }
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setBackgroundDrawable(
            AppCompatResources.getDrawable(this, R.color.primary_dark)
        )
        supportActionBar?.elevation = 0.0F
    }

    private fun updateHeadsets(todos: ArrayList<Headset>) {
        headsetAdapter.updateList(todos)

        Handler(Looper.getMainLooper()).postDelayed({
            disableShimmer()
        }, 1500)
    }

    private fun setupRecyclerView() {
        val context = this

        startShimmer()

        binding.rvHeadsets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = headsetAdapter
        }
    }

    private fun startShimmer() {
        binding.rvHeadsets.visibility = View.GONE

        runOnUiThread {
            binding.shimmerHeadsets.visibility = View.VISIBLE
            binding.shimmerHeadsets.startShimmer()
        }
    }

    private fun disableShimmer() {
        binding.rvHeadsets.visibility = View.VISIBLE

        runOnUiThread {
            binding.shimmerHeadsets.visibility = View.GONE
            binding.shimmerHeadsets.stopShimmer()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_headsets, menu)

        val drawable = menu.getItem(0).icon
        drawable.mutate()

        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val search = menu.findItem(R.id.action_search)
        val searchView = search.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        val textChangeListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String): Boolean {
                headsetAdapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                headsetAdapter.getFilter().filter(query)
                return true
            }
        }
        searchView.setOnQueryTextListener(textChangeListener)

        return super.onCreateOptionsMenu(menu)
    }
}