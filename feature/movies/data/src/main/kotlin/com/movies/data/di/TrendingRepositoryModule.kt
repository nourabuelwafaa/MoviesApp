package com.movies.data.di

import com.movies.data.repository.MoviesRepositoryImpl
import com.movies.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MoviesRepositoryModule {
    @Binds
    fun bindsMoviesRepository(
        impl: MoviesRepositoryImpl
    ): MoviesRepository
}
