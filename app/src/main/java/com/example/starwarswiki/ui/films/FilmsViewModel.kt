package com.example.starwarswiki.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarswiki.data.StartWarsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val startWarsApi: StartWarsApi
) : ViewModel() {

    private var _films: MutableLiveData<String> = MutableLiveData()
    val films: LiveData<String> get() = _films

    init {
        viewModelScope.launch {
            _films.value = startWarsApi.getFilms()
        }
    }
}