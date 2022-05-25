package com.waruna.starwarsplanets.util

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
data class Resource<out T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val message: String? = null
)