package br.com.andreitaiua.aemovies.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.andreitaiua.aemovies.R
import br.com.andreitaiua.aemovies.databinding.MovieItemBinding
import br.com.andreitaiua.aemovies.domain.model.Movie
import com.bumptech.glide.Glide

class MovieAdapter(
    private val listener: MovieListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var items: MutableList<Movie> = mutableListOf()

    fun setItems(values: List<Movie>) {
        this.items = values.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        val context = holder.binding.root.context
        Glide.with(holder.binding.root).load(item.image).into(holder.binding.movieImage)
        holder.binding.movieName.text = item.title
        holder.binding.movieRating.text = context.getString(R.string.movie_rating, item.rating)
        holder.binding.movieYear.text = context.getString(R.string.movie_year, item.year)
        holder.binding.root.setOnClickListener {
            listener.onMovieClick(item)
        }
    }


    override fun getItemCount(): Int = items.size

    inner class MovieViewHolder(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface MovieListener {
        fun onMovieClick(movie: Movie)
    }
}