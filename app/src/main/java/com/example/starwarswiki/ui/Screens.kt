package com.example.starwarswiki.ui

import com.example.starwarswiki.ui.film.FilmFragment
import com.example.starwarswiki.ui.films.FilmsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Films() = FragmentScreen {
        FilmsFragment()
    }

    fun Film(id: Int) = FragmentScreen("Film($id)") {
        FilmFragment.newInstance(id)
    }
}