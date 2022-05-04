package br.com.andreitaiua.aemovies.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieAPI {

    @Headers(
        value = [
            "X-RapidAPI-Host", "movies-app1.p.rapidapi.com",
            "X-RapidAPI-Key", "9a18ae3c88msh44cb282bed15813p1e3591jsn4009f255eff8"
        ]
    )
    @GET("/movies")
    fun getMovies(): Call<List<String>>
}
