package br.com.andreitaiua.aemovies.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.andreitaiua.aemovies.R
import br.com.andreitaiua.aemovies.databinding.MainFragmentBinding
import br.com.andreitaiua.aemovies.di.Injection
import br.com.andreitaiua.aemovies.presentation.adapter.MovieAdapter
import br.com.andreitaiua.aemovies.presentation.viewmodel.MainViewModel

class MainFragment : Fragment() {

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
        movieAdapter = MovieAdapter()
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
}