package br.com.andreitaiua.aemovies.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("_id") val id: String,
    val title: String,
    val description: String,
    val year: String,
    val rating: String,
    val image: String
)