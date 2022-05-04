package br.com.andreitaiua.aemovies.data

import br.com.andreitaiua.aemovies.data.network.MovieAPI
import br.com.andreitaiua.aemovies.data.network.Network

class MovieRepositoryImpl {

    private val retrofit = Network.getRetrofit()

    fun getMovies(): List<String> {
        return try {
            val services = retrofit.create(MovieAPI::class.java)
            val response = services.getMovies().execute()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        } catch (exception: Exception) {
            emptyList()
        }
    }

}