package com.movies.domain.usecase

import com.movies.domain.entity.Movie
import org.junit.Assert.assertEquals
import org.junit.Test

class MoviesUseCaseTest {

    private val useCase = MoviesUseCase()

    @Test
    fun `useCase is returning movies`() {
        val movies = useCase.invoke()
        assertEquals(emptyList<Movie>(), movies)
    }

}
