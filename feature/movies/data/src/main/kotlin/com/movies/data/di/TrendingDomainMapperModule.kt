package com.movies.data.di

import com.movies.data.mapper.DomainMapper
import com.movies.data.mapper.DomainMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainMapperModule {
    @Binds
    fun bindsDomainMapper(
        impl: DomainMapperImpl
    ): DomainMapper
}
