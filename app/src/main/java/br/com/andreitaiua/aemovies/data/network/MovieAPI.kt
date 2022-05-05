package br.com.andreitaiua.aemovies.data.network

import br.com.andreitaiua.aemovies.data.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieAPI {

    @Headers(
        value = [
            "x-rapidapi-host: movies-app1.p.rapidapi.com",
            "x-rapidapi-key: 9a18ae3c88msh44cb282bed15813p1e3591jsn4009f255eff8"
        ]
    )
    @GET("movies/")
    fun fetchMovies(): Call<MoviesResponse>
}
