package br.com.andreitaiua.aemovies.domain

import br.com.andreitaiua.aemovies.data.MovieRepositoryImpl


class GetMoviesUseCase constructor(private val repositoryImpl: MovieRepositoryImpl) {

    fun getMovies(): List<String> {
        val movies = repositoryImpl.getMovies()
        val resultfilter = movies.filter { movie ->
            movie == "Action"
        }
        return resultfilter
    }

}