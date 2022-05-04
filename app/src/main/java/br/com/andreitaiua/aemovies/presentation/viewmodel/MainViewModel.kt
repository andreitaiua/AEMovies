package br.com.andreitaiua.aemovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase

class MainViewModel constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    fun loadMovies() {
        //TODO Chamar Loading
        val movies = getMoviesUseCase.getMovies()
        //TODO Esconder loading
        if (movies.isNotEmpty()) {
            //TODO Atualiza a tela
        } else {
            //TODO Sem filme
        }
    }
}