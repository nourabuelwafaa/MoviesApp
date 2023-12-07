package com.movies.data.remote

import com.movies.data.dto.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    // TODO: extract api key
    @GET("3/discover/movie?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3")
    suspend fun movies(): Response<MoviesResponse>
}
