package com.waruna.starwarsplanets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waruna.starwarsplanets.databinding.ItemPlanetBinding
import com.waruna.starwarsplanets.models.Planet
import com.waruna.starwarsplanets.util.Constants.IMAGE_URL
import com.waruna.starwarsplanets.util.loadImage

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
class PlanetsAdapter(
    private val list: MutableList<Planet>,
    private val callback: (Planet) -> Unit
) :
    RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPlanetBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.run {
        bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun addItems(list: List<Planet>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {
            binding.textName.text = planet.name
            binding.textClimate.text = planet.climate
            binding.imageIcon.loadImage(IMAGE_URL)

            binding.root.setOnClickListener {
                callback.invoke(planet)
            }
        }
    }
}