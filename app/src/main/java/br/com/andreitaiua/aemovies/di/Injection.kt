package br.com.andreitaiua.aemovies.di

import br.com.andreitaiua.aemovies.data.MovieRepositoryImpl
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase

object Injection {

    private val repository: MovieRepositoryImpl by lazy {
        MovieRepositoryImpl()
    }
    private val getMoviesUseCase: GetMoviesUseCase by lazy {
        GetMoviesUseCase(repository)
    }
    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(getMoviesUseCase)
    }
}