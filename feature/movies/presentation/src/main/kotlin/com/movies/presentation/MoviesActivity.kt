package com.movies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.movies.feature.movies.presentation.R
import com.movies.presentation.model.MoviesView
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
                MoviesAdapter(it) { movie -> showDetails(movie) }
        }
    }

    private fun showDetails(movie: MoviesView) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_DETAILS, movie)
        startActivity(intent)
    }

    companion object {
        const val MOVIE_DETAILS = "movieDetails"
    }
}
