package com.waruna.starwarsplanets.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waruna.starwarsplanets.models.Planet
import com.waruna.starwarsplanets.network.PlanetApi
import com.waruna.starwarsplanets.util.Resource
import com.waruna.starwarsplanets.util.setError
import com.waruna.starwarsplanets.util.setLoading
import com.waruna.starwarsplanets.util.setSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val planetApi: PlanetApi) : ViewModel() {

    val liveDataPlanets = MutableLiveData<Resource<List<Planet>>>()

    fun getPlanets() {
        liveDataPlanets.setLoading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = planetApi.getPlanets(1)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let {
                            liveDataPlanets.setSuccess(it)
                        }
                    } else {
                        liveDataPlanets.setError(response.message())
                    }
                }
            } catch (ex: Exception) {
                liveDataPlanets.setError("Something went wrong!")
            }
        }
    }

}