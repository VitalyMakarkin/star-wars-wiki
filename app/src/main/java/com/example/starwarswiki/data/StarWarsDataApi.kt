package com.example.starwarswiki.data

import javax.inject.Inject

class StartWarsApi @Inject constructor() {
    suspend fun getFilms(): String {
//        val url = "https://swapi.dev/films/"
        return "Films string"
    }
}