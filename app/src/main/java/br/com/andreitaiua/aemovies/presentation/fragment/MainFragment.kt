package br.com.andreitaiua.aemovies.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.andreitaiua.aemovies.databinding.MainFragmentBinding
import br.com.andreitaiua.aemovies.di.Injection
import br.com.andreitaiua.aemovies.domain.model.Movie
import br.com.andreitaiua.aemovies.presentation.MainActivity
import br.com.andreitaiua.aemovies.presentation.adapter.MovieAdapter
import br.com.andreitaiua.aemovies.presentation.viewmodel.MainViewModel

class MainFragment : Fragment(), MovieAdapter.MovieListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels { Injection.viewModelFactory }
    private lateinit var viewBinding: MainFragmentBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieAdapter = MovieAdapter(this@MainFragment)
        return MainFragmentBinding.inflate(layoutInflater).apply {
            viewBinding = this
            movieList.adapter = movieAdapter
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeChanges()
    }

    private fun observeChanges() {
        viewModel.isLoadingVisible.observe(viewLifecycleOwner) { isVisible ->
            viewBinding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        viewModel.isContentVisible.observe(viewLifecycleOwner) { isVisible ->
            viewBinding.movieList.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        viewModel.model.observe(viewLifecycleOwner) { movies ->
            movieAdapter.setItems(movies)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMovies()
    }

    override fun onMovieClick(movie: Movie) {
        (activity as? MainActivity)?.showFragment(
            fragment = MovieDescriptionFragment.newInstance(
                image = movie.image,
                title = movie.title,
                year = movie.year,
                description = movie.description
            )
        )
    }
}