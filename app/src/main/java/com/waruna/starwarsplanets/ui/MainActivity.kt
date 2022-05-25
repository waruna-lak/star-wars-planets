package com.waruna.starwarsplanets.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.waruna.starwarsplanets.adapters.PlanetsAdapter
import com.waruna.starwarsplanets.databinding.ActivityMainBinding
import com.waruna.starwarsplanets.models.Planet
import com.waruna.starwarsplanets.util.Resource
import com.waruna.starwarsplanets.util.ResourceState
import com.waruna.starwarsplanets.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), (Planet) -> Unit {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()

    private lateinit var planetsAdapter: PlanetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        planetsAdapter = PlanetsAdapter(mutableListOf(), this@MainActivity)
        binding.recyclerPlanets.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = planetsAdapter
        }

        model.liveDataPlanets.observe(this) { handlePlanets(it) }
        model.getPlanets()
    }

    override fun invoke(planet: Planet) {
        // open details
    }

    private fun handlePlanets(resource: Resource<List<Planet>>) {
        resource.let {
            when (it.state) {
                ResourceState.LOADING -> showProgress()
                ResourceState.SUCCESS -> {
                    it.data?.let { data -> planetsAdapter.addItems(data) }
                    hideProgress()
                }
                ResourceState.ERROR -> {
                    hideProgress()
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Alert")
                        .setMessage(it.message)
                        .create()
                    dialog.show()
                }
            }
        }
    }

    private fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progress.visibility = View.GONE
    }
}