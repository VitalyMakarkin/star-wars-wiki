package com.example.starwarswiki.data

import com.example.starwarswiki.model.Film
import com.example.starwarswiki.model.FilmsPage
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {
    @GET("films/")
    suspend fun getFilms(): Response<FilmsPage>

    @GET("films/{id}")
    suspend fun getFilm(id: Int): Response<Film>
}