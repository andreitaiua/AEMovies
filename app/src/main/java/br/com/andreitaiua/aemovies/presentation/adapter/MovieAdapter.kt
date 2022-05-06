package br.com.andreitaiua.aemovies.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.andreitaiua.aemovies.databinding.MovieItemBinding
import br.com.andreitaiua.aemovies.domain.model.Movie
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

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
        Glide.with(holder.binding.root).load(item.image).into(holder.binding.movieImage)
        holder.binding.movieName.text = item.title
        holder.binding.movieRating.text = item.rating
        holder.binding.movieYear.text = item.year
    }

    override fun getItemCount(): Int = items.size

    inner class MovieViewHolder(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}