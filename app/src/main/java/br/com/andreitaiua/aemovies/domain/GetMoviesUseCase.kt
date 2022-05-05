package br.com.andreitaiua.aemovies.domain

import br.com.andreitaiua.aemovies.data.MovieRepositoryImpl
import br.com.andreitaiua.aemovies.data.model.mapFrom
import br.com.andreitaiua.aemovies.domain.model.Movie

class GetMoviesUseCase constructor(private val repositoryImpl: MovieRepositoryImpl) {

    fun getMovies(): List<Movie> {
        val response = repositoryImpl.getMovies()
        return response.map { movieResponse ->
            movieResponse.mapFrom()
        }
    }

    //fun getMovies(): List<Movie> = repositoryImpl.getMovies().map { movieResponse -> movieResponse.mapFrom() }
}