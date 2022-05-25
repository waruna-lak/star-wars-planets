package com.waruna.starwarsplanets.network

import com.waruna.starwarsplanets.models.PlanetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
interface PlanetApi {

    @GET("planets/")
    suspend fun getPlanets(
        @Query("page") page: Int
    ): Response<PlanetResponse>

}