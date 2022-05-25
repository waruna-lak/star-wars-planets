package com.waruna.starwarsplanets.util

import androidx.lifecycle.MutableLiveData

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T, message: String? = null) =
    postValue(Resource(ResourceState.SUCCESS, data, message))

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(message: String? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            message
        )
    )