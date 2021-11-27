package com.example.lily.ui.screens.tracks

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.tracks.Tracks
import com.example.domain.usecases.FetchSongs
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TracksViewModel(private val fetchSongs: FetchSongs) : ViewModel() {

    init {
        initSongs()
    }

    private val _tracks = mutableStateOf(Tracks("", listOf(),"",0))
    val tracks :State<Tracks> get() = _tracks

    private fun initSongs()=viewModelScope.launch {
        fetchSongs().collect {
            _tracks.value = it
        }
    }

}