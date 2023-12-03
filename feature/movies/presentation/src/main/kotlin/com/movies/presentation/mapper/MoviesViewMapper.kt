package com.movies.presentation.mapper

import com.movies.domain.entity.Movie
import com.movies.presentation.model.MoviesView

interface MoviesViewMapper {
    fun map(items: List<Movie>): List<MoviesView>
}

class MoviesViewMapperImpl : MoviesViewMapper {
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
