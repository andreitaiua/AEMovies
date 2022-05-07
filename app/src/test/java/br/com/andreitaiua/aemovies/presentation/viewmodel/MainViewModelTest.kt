package br.com.andreitaiua.aemovies.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.andreitaiua.aemovies.domain.GetMoviesUseCase
import br.com.andreitaiua.aemovies.domain.model.Movie
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val getMoviesUseCase: GetMoviesUseCase = mockk()
    private val viewModel = MainViewModel(getMoviesUseCase, testDispatcher)

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun loadMovies_withSuccess() = runTest {
        every {
            getMoviesUseCase.getMovies()
        } returns listOf(makeMovie())

        viewModel.loadMovies()

        assertTrue(viewModel.moviesModel.value?.size == 1)
        assertTrue(viewModel.isContentVisible.value == true)
    }

    @Test
    fun loadMovies_withFail() = runTest {
        every {
            getMoviesUseCase.getMovies()
        } returns emptyList()

        viewModel.loadMovies()

        assertTrue(viewModel.isErrorContentVisible.value == true)
        assertTrue(viewModel.isContentVisible.value == false)
    }

    @Test
    fun loadMovies_callUseCase() = runTest {
        every {
            getMoviesUseCase.getMovies()
        } returns emptyList()

        viewModel.loadMovies()

        verify {
            getMoviesUseCase.getMovies()
        }
    }


    private fun makeMovie() = Movie(
        id = "13",
        title = "Titulo",
        description = "No gas total 6",
        year = "2002",
        rating = "5/10",
        image = "images"
    )

}