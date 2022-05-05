package br.com.andreitaiua.aemovies.data.model

import br.com.andreitaiua.aemovies.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val status: Int,
    val success: Boolean,
    val messageStatus: String,
    @SerializedName("results") val movies: List<MovieResponse>
)

data class MovieResponse(
    @SerializedName("_id") val id: String,
    val uuid: String,
    val title: String,
    val rating: String,
    val year: String,
    val description: String,
    val genres: List<GenreResponse>,
    val release: String,
    val image: String
)

data class GenreResponse(
    val name: String,
    val uuid: String
)

fun MovieResponse.mapFrom() = Movie(
    id = this.id,
    title = this.title,
    description = this.description,
    year = this.year,
    image = this.image
)
