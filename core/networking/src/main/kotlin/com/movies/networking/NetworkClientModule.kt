package com.movies.networking

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientModule {
    private const val BASE_URL = "https://developers.themoviedb.org/"

    @Provides
    @Singleton
    fun okHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
        ).build()

    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .callFactory(okHttpCallFactory())
        .addConverterFactory(GsonConverterFactory.create()).build()
}
