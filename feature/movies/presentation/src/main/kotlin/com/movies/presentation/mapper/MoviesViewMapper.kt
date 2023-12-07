package com.movies.presentation.mapper

import com.movies.domain.entity.Movie
import com.movies.presentation.model.MoviesView
import javax.inject.Inject

interface MoviesViewMapper {
    fun map(items: List<Movie>): List<MoviesView>
}

class MoviesViewMapperImpl @Inject constructor() : MoviesViewMapper {
    override fun map(items: List<Movie>): List<MoviesView> {
        return items.map {
            MoviesView(
                title = it.title,
                date = extractYear(it.year),
                imageUrl = "https://image.tmdb.org/t/p/w500/${it.imageUrl}",
                description = it.description
            )
        }
    }

    private fun extractYear(releaseDate: String): String {
        return try {
            releaseDate.split("-").first()
        } catch (e: Exception) {
            releaseDate
        }
    }
}
