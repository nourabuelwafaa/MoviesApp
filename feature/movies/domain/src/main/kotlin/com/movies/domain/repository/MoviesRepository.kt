package com.movies.domain.repository

import com.movies.domain.entity.Movie

interface MoviesRepository {
    suspend fun getMovies(): List<Movie>
}