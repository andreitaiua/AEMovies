package br.com.andreitaiua.aemovies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase
import br.com.andreitaiua.aemovies.presentation.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val getMoviesUseCase: GetMoviesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getMoviesUseCase) as T
    }

}