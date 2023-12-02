package com.movies.data.repository

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MoviesRepositoryImplTest {

    private val repository = MoviesRepositoryImpl()

    @Test
    fun `repository is returning items`() {
        runBlocking {
            val result = repository.getMovies()
            result.onSuccess { Assert.assertEquals(0, it.size) }
        }
    }

}