package com.example.starwarswiki.ui

import com.example.starwarswiki.ui.films.FilmsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Films() = FragmentScreen {
        FilmsFragment()
    }
}