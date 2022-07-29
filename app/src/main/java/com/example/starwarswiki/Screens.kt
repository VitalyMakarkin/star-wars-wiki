package com.example.starwarswiki

import com.example.starwarswiki.ui.films.FilmsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Films() = FragmentScreen {
        FilmsFragment()
    }
}