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

    private val albumState = Album(
        artist = AlbumArtist(
            id = 27,
            "Daft Punk",
            picture = "",
            pictureBig = "",
            pictureMedium = "",
            pictureSmall = "",
            pictureXl = "",
            trackList = "",
            type = ""
        ),
        contributors = listOf(),
        duration = 8,
        available = true,
        coverXl = "",
        coverSmall = "",
        cover = "",
        coverMedium = "",
        coverBig = "",
        fans = 247502,
        genreId = 21,
        genres = AlbumGenres(data = listOf()),
        id = 2944,
        link = "",
        md5Image = "",
        nbTracks = 23,
        recordType = "",
        releaseDate = "",
        title = "Discovery",
        trackList = "",
        tracks = AlbumTracks(
            data = listOf(
                AlbumTrack(
                    artist = AlbumTrackArtist(
                        id = 1,
                        name = "Sean Paul",
                        trackList = "",
                        type = ""
                    ),
                    duration = 2,
                    explicitLyrics = false,
                    explicitContentLyrics = 1,
                    explicitContentCover = 1,
                    id = 5,
                    link = "",
                    md5Image = "",
                    preview = "",
                    rank = 2,
                    readable = false,
                    title = "",
                    titleShort = "Alafu",
                    titleVersion = "new",
                    type = "Lalala"
                )
            )
        ),
        type = ""
    )

    private val _album: MutableState<Album> = mutableStateOf(albumState)
    val album: State<Album> get() = _album

    fun getAlbum(albumId:Int) = viewModelScope.launch {
        fetchAlbum.invoke(albumId).collect {
            _album.value = it
        }
    }

}