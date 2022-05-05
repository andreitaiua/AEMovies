package br.com.andreitaiua.aemovies.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase
import br.com.andreitaiua.aemovies.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    val isLoadingVisible: MutableLiveData<Boolean> = MutableLiveData()
    val model: MutableLiveData<Movie> = MutableLiveData()

    fun loadMovies() {
        isLoadingVisible.value = true

        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.getMovies()
            isLoadingVisible.postValue(false)

            if (movies.isNotEmpty()) {
                model.postValue(movies.random())
            } else {

            }
        }


    }
}