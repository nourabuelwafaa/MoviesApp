package com.movies.domain.usecase

import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke(): Result<List<Movie>> {
        return repository.getMovies()
    }

}
