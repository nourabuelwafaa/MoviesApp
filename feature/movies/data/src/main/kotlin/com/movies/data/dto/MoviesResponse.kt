package com.movies.data.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponse(@SerializedName("results") val items: List<MovieDto>)

data class MovieDto(
    val title: String,
    @SerializedName("poster_path")
    val posterUrl: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
)
