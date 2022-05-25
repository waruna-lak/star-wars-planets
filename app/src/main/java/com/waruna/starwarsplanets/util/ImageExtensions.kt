package com.waruna.starwarsplanets.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.waruna.starwarsplanets.R

/**
 * Created by Waruna Jayasinghe on 5/25/2022.
 */

fun ImageView.loadImage(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_placeholder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}