package com.waruna.starwarsplanets.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.waruna.starwarsplanets.adapters.PlanetsAdapter
import com.waruna.starwarsplanets.databinding.ActivityMainBinding
import com.waruna.starwarsplanets.models.Planet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), (Planet) -> Unit {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerPlanets.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PlanetsAdapter(mutableListOf(), this@MainActivity)
        }
    }

    override fun invoke(planet: Planet) {
        // open details
    }
}