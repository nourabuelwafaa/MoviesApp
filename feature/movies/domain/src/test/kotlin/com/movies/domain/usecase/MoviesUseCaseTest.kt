package com.movies.domain.usecase

import com.movies.domain.entity.Movie
import com.movies.domain.repository.MoviesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MoviesUseCaseTest {

    private val mockRepository: MoviesRepository = mockk()
    private val useCase = MoviesUseCase(mockRepository)

    @Test
    fun `useCase is returning movies`() {
        coEvery { mockRepository.getMovies() } returns listOf(
            Movie(),
            Movie()
        )
        runBlocking {
            val movies = useCase.invoke()
            assertEquals(2, movies.size)
            coVerify { mockRepository.getMovies() }
        }
    }

}
