package br.com.andreitaiua.aemovies.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.andreitaiua.aemovies.databinding.MovieFragmentBinding
import com.bumptech.glide.Glide

private const val IMAGE_KEY = "IMAGE_KEY"
private const val TITLE_KEY = "TITLE_KEY"
private const val YEAR_KEY = "YEAR_KEY"
private const val DESC_KEY = "DESC_KEY"

class MovieDescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MovieFragmentBinding.inflate(layoutInflater).apply {
            val arguments = this@MovieDescriptionFragment.arguments
            val image = arguments?.getString(IMAGE_KEY)
            val title = arguments?.getString(TITLE_KEY)
            val year = arguments?.getString(YEAR_KEY)
            val desc = arguments?.getString(DESC_KEY)
            Glide.with(this@MovieDescriptionFragment)
                .load(image)
                .into(imageMovie)
                fieldTitle.text = title
                movieDate.text = year
                descriptionMovie.text = desc
        }.root
    }

    companion object {
        fun newInstance(
            image: String,
            title: String,
            year: String,
            description: String
        ) = MovieDescriptionFragment().apply {
            arguments = Bundle().also {
                it.putString(IMAGE_KEY, image)
                it.putString(TITLE_KEY, title)
                it.putString(YEAR_KEY, year)
                it.putString(DESC_KEY, description)
            }
        }
    }
}