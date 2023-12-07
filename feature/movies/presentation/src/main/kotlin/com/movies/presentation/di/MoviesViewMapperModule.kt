package com.movies.presentation.di

import com.movies.presentation.mapper.MoviesViewMapper
import com.movies.presentation.mapper.MoviesViewMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MoviesViewMapperModule {
    @Binds
    fun bindsMoviesReposMapper(
        impl: MoviesViewMapperImpl
    ): MoviesViewMapper
}
