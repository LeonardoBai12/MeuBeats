package io.lb.meubeats.ui.main

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityMainBinding
import io.lb.meubeats.model.headset.Headset
import io.lb.meubeats.utils.ResourceCreator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val headsetAdapter = MainHeadsetAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupActionBar()

        updateHeadsets(ResourceCreator.exampleHeadsets())
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