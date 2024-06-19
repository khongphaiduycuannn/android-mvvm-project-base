package com.example.androidmvvmprojectbase.data

import com.google.gson.annotations.SerializedName

data class Dog(
    val id: String,
    val name: String?,
    val image: String?,
    val description: String?,
    @SerializedName("min_life")
    val minLife: Int?,
    @SerializedName("max_life")
    val maxLife: Int?
)