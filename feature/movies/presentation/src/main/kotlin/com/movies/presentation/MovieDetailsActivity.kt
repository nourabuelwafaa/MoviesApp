package com.movies.presentation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.movies.feature.movies.presentation.databinding.ActivityMovieDetailsBinding
import com.movies.presentation.model.MoviesView

class MovieDetailsActivity :
    AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movie =
            intent.getParcelableExtra<MoviesView>(MoviesActivity.MOVIE_DETAILS)

        movie?.let {
            binding.dateTv.text = it.date
            binding.titleTv.text = it.title
            binding.descTv.text = it.description
            binding.posterIv.load(it.imageUrl)
        }
    }

}
