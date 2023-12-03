package com.movies.data.remote

import retrofit2.Response

interface MoviesApi {
    suspend fun movies(): Response<Any>
}