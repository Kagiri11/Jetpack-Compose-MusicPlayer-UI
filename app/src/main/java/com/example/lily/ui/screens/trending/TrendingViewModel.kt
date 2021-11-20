package com.example.lily.ui.screens.trending

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.editorial.Albums
import com.example.domain.models.editorial.Editorial
import com.example.domain.models.editorial.EditorialArtists
import com.example.domain.models.editorial.EditorialTracks
import com.example.domain.usecases.FetchAlbum
import com.example.domain.usecases.FetchEditorial
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class TrendingViewModel(
    private val fetchEditorial: FetchEditorial,
    private val fetchAlbum: FetchAlbum
): ViewModel() {

    private val _editorial : MutableLiveData<Editorial> = MutableLiveData()
    val editorial : LiveData<Editorial> get() = _editorial

    val editorialState = Editorial(
        albums = Albums(listOf(),0),artists = EditorialArtists(listOf(),0,),tracks = EditorialTracks(
            listOf(),0)
    )

    val edt: MutableState<Editorial> = mutableStateOf(editorialState)
    init {
        getEditorials()
    }

    private fun getEditorials(){
        viewModelScope.launch {
            val editorial= fetchEditorial.invoke()
            editorial.collect {
                Timber.i("${it.albums.total}")
                _editorial.value = it
                edt.value = it
            }
        }

    }

}