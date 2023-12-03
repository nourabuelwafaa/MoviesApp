package com.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.movies.feature.movies.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
    }
}
