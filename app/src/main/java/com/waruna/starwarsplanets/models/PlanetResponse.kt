package com.waruna.starwarsplanets.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
data class PlanetResponse(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: List<Planet>? = null,
)