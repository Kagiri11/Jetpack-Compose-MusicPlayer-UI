package com.example.domain.repository

import com.example.domain.models.album.Album
import com.example.domain.models.editorial.Editorial
import com.example.domain.models.tracks.Tracks
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    /**
     * Fetch the chosen albums,playlists, tracks and artists provided by the api service.
     * For simplicity we fetch the first one so no need to pass an id as parameter.
     */
    suspend fun fetchEditorial(): Flow<Editorial>

    //Fetch album by its ID
    suspend fun fetchAlbum(albumId:Int): Flow<Album>

    suspend fun fetchSongs():Flow<Tracks>
}