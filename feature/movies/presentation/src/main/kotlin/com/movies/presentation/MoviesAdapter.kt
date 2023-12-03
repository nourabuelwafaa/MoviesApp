package com.movies.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movies.feature.movies.presentation.databinding.SingleMovieViewBinding
import com.movies.presentation.model.MoviesView
import com.movies.feature.movies.presentation.R

class MoviesAdapter(
    private val movies: List<MoviesView>,
    private val onItemClicked: (MoviesView) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return MovieViewHolder(
            inflate(parent, R.layout.single_movie_view)
        )
    }

    private fun inflate(parent: ViewGroup, layoutId: Int) =
        LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val movie = movies[position]
        val binding = (holder as MovieViewHolder).binding
        binding.titleTv.text = movie.title
        binding.dateTv.text = movie.date
        binding.root.setOnClickListener {
            onItemClicked(movie)
        }
    }
}

class MovieViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    val binding: SingleMovieViewBinding =
        SingleMovieViewBinding.bind(view)
}
