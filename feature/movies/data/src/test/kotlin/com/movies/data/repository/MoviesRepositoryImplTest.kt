package com.movies.data.repository

import com.movies.data.dto.MoviesResponse
import com.movies.data.remote.MoviesApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class MoviesRepositoryImplTest {
    private val mockApi = mockk<MoviesApi>()
    private val repository = MoviesRepositoryImpl(mockApi)


    @Test
    fun `repository is returning items`() {
        coEvery { mockApi.movies() } returns
                Response.success(MoviesResponse(emptyList()))
        runBlocking {
            val result = repository.getMovies()
            Assert.assertEquals(0, result.getOrNull()!!.size)
        }
    }

    @Test
    fun `repository is returning failure in case api failed`() {
        coEvery { mockApi.movies() } returns
                Response.error(
                    500,
                    ResponseBody.create(null, "")
                )
        runBlocking {
            val result = repository.getMovies()
            Assert.assertEquals(result.isFailure, true)
        }
    }


    @Test
    fun `repository is returning failure in case api throw exception`() {
        coEvery { mockApi.movies() } throws Exception()
        runBlocking {
            val result = repository.getMovies()
            Assert.assertEquals(result.isFailure, true)
        }
    }

}