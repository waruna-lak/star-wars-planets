package com.waruna.starwarsplanets.util

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */
sealed class ResourceState {
    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}