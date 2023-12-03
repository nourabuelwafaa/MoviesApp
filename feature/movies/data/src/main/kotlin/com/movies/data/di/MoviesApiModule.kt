package com.movies.data.di

import com.movies.data.remote.MoviesApi
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object MoviesApiModule {
    @Provides
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi =
        retrofit
            .create(MoviesApi::class.java)
}
