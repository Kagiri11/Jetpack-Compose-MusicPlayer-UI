package com.example.lily.ui.screens.album

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.album.*
import com.example.domain.usecases.FetchAlbum
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AlbumViewModel(private val fetchAlbum: FetchAlbum) : ViewModel() {

    init {
        getAlbum()
    }

    private val albumState = Album(
        artist = AlbumArtist(
            id = 27,
            "Daft Punk",
            picture = "",
            picture_big = "",
            picture_medium = "",
            picture_small = "",
            picture_xl = "",
            tracklist = "",
            type = ""
        ),
        contributors = listOf(),
        duration = 8,
        available = true,
        cover_xl = "",
        cover_small = "",
        cover = "",
        cover_medium = "",
        cover_big = "",
        fans = 247502,
        genre_id = 21,
        genres = AlbumGenres(data = listOf()),
        id = 2944,
        link = "",
        md5_image = "",
        nb_tracks = 23,
        record_type = "",
        release_date = "",
        title = "Discovery",
        tracklist = "",
        tracks = AlbumTracks(
            data = listOf(
                AlbumTrack(
                    artist = AlbumTrackArtist(
                        id = 1,
                        name = "Sean Paul",
                        tracklist = "",
                        type = ""
                    ),
                    duration = 2,
                    explicit_lyrics = false,
                    explicit_content_lyrics = 1,
                    explicit_content_cover = 1,
                    id = 5,
                    link = "",
                    md5_image = "",
                    preview = "",
                    rank = 2,
                    readable = false,
                    title = "",
                    title_short = "Alafu",
                    title_version = "new",
                    type = "Lalala"
                )
            )
        ),
        type = ""
    )

    private val _album: MutableState<Album> = mutableStateOf(albumState)
    val album: State<Album> get() = _album

    private fun getAlbum() = viewModelScope.launch {
        fetchAlbum.invoke(302127).collect {
            _album.value = it
        }
    }

}