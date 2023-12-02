package com.movies.domain.usecase

import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository

class MoviesUseCase(private val repository: MoviesRepository) {

    suspend fun invoke(): List<Movie> {
        return repository.getMovies()
    }

}