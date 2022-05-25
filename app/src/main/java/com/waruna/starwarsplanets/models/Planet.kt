package com.waruna.starwarsplanets.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
@Parcelize
data class Planet(
    @SerializedName("name") var name: String?,
    @SerializedName("rotation_period") var rotationPeriod: String?,
    @SerializedName("orbital_period") var orbitalPeriod: String?,
    @SerializedName("climate") var climate: String?,
    @SerializedName("gravity") var gravity: String?,
) : Parcelable