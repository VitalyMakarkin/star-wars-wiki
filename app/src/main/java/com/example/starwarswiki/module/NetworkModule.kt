package com.example.starwarswiki.module

import com.example.starwarswiki.data.StarWarsApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideService(json: Json): StarWarsApi {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(StarWarsApi::class.java)
    }
}