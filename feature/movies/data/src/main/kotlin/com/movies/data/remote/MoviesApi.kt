package com.movies.data.remote

import com.movies.data.dto.MoviesResponse
import retrofit2.Response

interface MoviesApi {
    suspend fun movies(): Response<MoviesResponse>
}