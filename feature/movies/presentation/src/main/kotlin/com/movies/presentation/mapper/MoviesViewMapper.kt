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
                date = it.year,
                imageUrl = it.imageUrl
            )
        }
    }
}
