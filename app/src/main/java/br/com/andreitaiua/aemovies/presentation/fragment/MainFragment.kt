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
import br.com.andreitaiua.aemovies.di.Injection
import br.com.andreitaiua.aemovies.presentation.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels { Injection.viewModelFactory }
    private lateinit var viewBinding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        viewBinding = view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeChanges()
    }

    private fun observeChanges() {
        val progressBar = viewBinding.findViewById<ProgressBar>(R.id.progress_bar)
        val textView = viewBinding.findViewById<TextView>(R.id.title)

        viewModel.isLoadingVisible.observe(viewLifecycleOwner) { isVisible ->
            progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        viewModel.model.observe(viewLifecycleOwner) { movie ->
            textView.text = movie.title
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMovies()
    }
}