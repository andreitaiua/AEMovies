package br.com.andreitaiua.aemovies.data

import br.com.andreitaiua.aemovies.data.model.MovieResponse
import br.com.andreitaiua.aemovies.data.network.MovieAPI
import br.com.andreitaiua.aemovies.data.network.Network

class MovieRepositoryImpl {

    private val retrofit = Network.getRetrofit()

    fun getMovies(): List<MovieResponse> {
        return try {
            val services = retrofit.create(MovieAPI::class.java)
            val response = services.fetchMovies().execute()
            val movieResponse = response.body()
            if (response.isSuccessful && movieResponse?.success == true) {
                movieResponse.movies
            } else {
                emptyList()
            }
        } catch (exception: Exception) {
            emptyList()
        }
    }

}