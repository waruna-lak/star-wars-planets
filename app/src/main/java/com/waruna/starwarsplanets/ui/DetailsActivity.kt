package com.waruna.starwarsplanets.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.waruna.starwarsplanets.R
import com.waruna.starwarsplanets.databinding.ActivityDetailsBinding
import com.waruna.starwarsplanets.models.Planet
import com.waruna.starwarsplanets.util.Constants.EXTRA_PLANET

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()
        initViews()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        supportActionBar?.title = getString(R.string.details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        if (intent.hasExtra(EXTRA_PLANET)) {
            val planet: Planet? = intent.getParcelableExtra(EXTRA_PLANET)
            planet?.let {
                binding.textName.text = it.name
                binding.textOrbit.text = it.orbitalPeriod
                binding.textGravity.text = it.gravity
            }
        }
    }
}