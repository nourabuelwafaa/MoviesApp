package com.movies.data.repository

import com.movies.data.remote.MoviesApi
import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val api: MoviesApi
) : MoviesRepository {
    override suspend fun getMovies(): Result<List<Movie>> {
        return try {
            val response = api.movies()
            if (response.isSuccessful && response.body() != null) {
                Result.success(emptyList())
            } else {
                Result.failure(Exception(response.message()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}