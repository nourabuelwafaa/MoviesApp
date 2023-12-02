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
        coEvery { mockRepository.getMovies() } returns Result.success(
            listOf(
                Movie(),
                Movie()
            )
        )

        runBlocking {
            val result = useCase.invoke()
            result.onSuccess { assertEquals(2, it.size) }
            coVerify { mockRepository.getMovies() }
        }
    }

}
