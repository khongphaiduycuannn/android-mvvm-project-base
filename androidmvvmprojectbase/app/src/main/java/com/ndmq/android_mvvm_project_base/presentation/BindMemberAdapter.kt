package com.ndmq.android_mvvm_project_base.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:imageUrl")
fun loadImageUrl(view: ImageView, imageUrl: String) {
    Glide.with(view).load(imageUrl).into(view)
}