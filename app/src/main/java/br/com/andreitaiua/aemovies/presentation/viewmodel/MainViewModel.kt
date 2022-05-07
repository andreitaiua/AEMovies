package br.com.andreitaiua.aemovies.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase
import br.com.andreitaiua.aemovies.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val isLoadingVisible: MutableLiveData<Boolean> = MutableLiveData()
    val isContentVisible: MutableLiveData<Boolean> = MutableLiveData(false)
    val isErrorContentVisible: MutableLiveData<Boolean> = MutableLiveData(false)
    val moviesModel: MutableLiveData<List<Movie>> = MutableLiveData()

    fun loadMovies() {
        isLoadingVisible.value = true
        viewModelScope.launch(dispatcher) {
            val movies = getMoviesUseCase.getMovies()
            isLoadingVisible.postValue(false)

            if (movies.isNotEmpty()) {
                isContentVisible.postValue(true)
                moviesModel.postValue(movies)
            } else {
                isContentVisible.postValue(false)
                isErrorContentVisible.postValue(true)
            }
        }
    }
}