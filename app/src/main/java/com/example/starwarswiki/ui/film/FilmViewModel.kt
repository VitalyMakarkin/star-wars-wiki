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
        val stateId = savedStateHandle.get<Int>("param_id")
        Log.d("FILM", "Film ID: $stateId")

        viewModelScope.launch {
            _film.value = starWarsApi.getFilm(stateId!!).body()
            Log.d("FILM", _film.value.toString())
        }
    }
}