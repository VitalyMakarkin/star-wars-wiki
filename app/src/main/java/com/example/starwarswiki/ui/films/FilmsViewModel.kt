package com.example.starwarswiki.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarswiki.data.StarWarsApi
import com.example.starwarswiki.model.FilmsPage
import com.example.starwarswiki.ui.Screens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val starWarsApi: StarWarsApi,
    private val router: Router
) : ViewModel() {

    private var _films: MutableLiveData<FilmsPage> = MutableLiveData()
    val films: LiveData<FilmsPage> get() = _films

    init {
        viewModelScope.launch {
            _films.value = starWarsApi.getFilms().body()
        }
    }

    fun displayFilm() {
        router.navigateTo(Screens.Film(1))
    }
}