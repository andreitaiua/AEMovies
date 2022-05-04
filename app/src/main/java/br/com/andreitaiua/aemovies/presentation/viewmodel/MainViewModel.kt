package br.com.andreitaiua.aemovies.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase

class MainViewModel constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    val isLoadingVisible: MutableLiveData<Boolean> = MutableLiveData()

    fun loadMovies() {
        isLoadingVisible.value = true
        //TODO Chamar Loading
        val movies = getMoviesUseCase.getMovies()
        //TODO Esconder loading
        isLoadingVisible.value = false

        if (movies.isNotEmpty()) {
            //TODO Atualiza a tela
        } else {
            //TODO Sem filme
        }
    }
}