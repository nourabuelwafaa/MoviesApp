package com.movies.data.repository

import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMovies(): Result<List<Movie>> {
        return Result.success(emptyList())
    }
}