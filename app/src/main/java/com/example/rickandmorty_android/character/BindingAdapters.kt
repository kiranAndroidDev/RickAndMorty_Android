package com.example.rickandmorty_android.character

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("url")
fun ImageView.loadImage(url: String) {
    this.load(url) {
        transformations(CircleCropTransformation())
    }
}
