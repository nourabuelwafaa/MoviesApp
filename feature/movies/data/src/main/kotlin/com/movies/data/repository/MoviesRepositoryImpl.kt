package com.movies.data.repository

import com.movies.data.mapper.DomainMapper
import com.movies.data.remote.MoviesApi
import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesApi,
    private val mapper: DomainMapper

) : MoviesRepository {
    override suspend fun getMovies(): Result<List<Movie>> {
        return try {
            val response = api.movies()
            val moviesResponse = response.body()
            if (response.isSuccessful && moviesResponse != null) {
                Result.success(mapper.map(moviesResponse.items))
            } else {
                Result.failure(Exception(response.message()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}