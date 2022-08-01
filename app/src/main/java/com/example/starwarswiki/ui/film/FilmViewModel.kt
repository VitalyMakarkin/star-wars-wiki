package com.example.starwarswiki.ui.film

import android.util.Log
import androidx.lifecycle.*
import com.example.starwarswiki.data.StarWarsApi
import com.example.starwarswiki.model.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val starWarsApi: StarWarsApi,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private var _film: MutableLiveData<Film> = MutableLiveData()
    val film: LiveData<Film> get() = _film

    init {
        //_film = savedStateHandle.getLiveData<String>("id").switchMap

        val stateId = savedStateHandle.get<Int>("PARAM_ID")
        Log.d("FILM", "Film ID: $stateId")

        viewModelScope.launch {
            TODO("Pass argument from fragment to view model")
            //_film.value = starWarsApi.getFilm().
        }
    }
}