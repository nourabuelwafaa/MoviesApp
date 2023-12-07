package com.movies.presentation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.movies.feature.movies.presentation.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity :
    AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
