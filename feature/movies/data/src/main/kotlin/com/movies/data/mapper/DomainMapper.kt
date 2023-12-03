package com.movies.data.mapper

import com.movies.data.dto.MovieDto
import com.movies.domain.entity.Movie


interface DomainMapper {
    fun map(items: List<MovieDto>): List<Movie>
}

class DomainMapperImpl : DomainMapper {
    override fun map(items: List<MovieDto>): List<Movie> {
        return items.map {
            Movie(
                title = it.title,
                description = it.overview,
                imageUrl = it.posterUrl,
                year = it.releaseDate
            )
        }
    }
}
