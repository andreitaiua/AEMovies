package br.com.andreitaiua.aemovies.domain

import br.com.andreitaiua.aemovies.data.MovieRepositoryImpl
import br.com.andreitaiua.aemovies.data.model.MovieResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class GetMoviesUseCaseTest {
    private val repository: MovieRepositoryImpl = mockk()
    private val getMoviesUseCase = GetMoviesUseCase(repository)

    @Test
    fun getMovies() {
        val listMovies = listOf(makeMovie())
        every {
            repository.getMovies()
        } returns listMovies

        val movies = getMoviesUseCase.getMovies()

        assertTrue(movies.size == listMovies.size)
        assertEquals(listMovies.first().id, movies.first().id)
        assertEquals(listMovies.first().title, movies.first().title)
        assertEquals(listMovies.first().description, movies.first().description)
        assertEquals(listMovies.first().year, movies.first().year)
        assertEquals(listMovies.first().rating, movies.first().rating)
        assertEquals(listMovies.first().image, movies.first().image)
    }

    private fun makeMovie() = MovieResponse(
        id = "13",
        title = "Titulo",
        description = "No gas total 6",
        year = "2002",
        rating = "5/10",
        image = "images",
        uuid = "uuid",
        genres = emptyList(),
        release = "release"
    )

}