package com.movies.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.movies.feature.movies.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {
    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        viewModel.getMovies()
        viewModel.moviesLiveData.observe(this) {
            findViewById<RecyclerView>(R.id.moviesRv).adapter =
                MoviesAdapter(it) {}
        }

    }
}
