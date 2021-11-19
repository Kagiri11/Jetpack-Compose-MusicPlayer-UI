package com.example.domain.repository

import com.example.domain.models.album.Album
import com.example.domain.models.album.Artist
import com.example.domain.models.album.Track
import com.example.domain.models.editorial.Editorial
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    /**
     * Fetch the chosen albums,playlists, tracks and artists provided by the api service.
     * For simplicity we fetch the first one so no need to pass an id as parameter.
     */
    suspend fun fetchEditorial(): Flow<Editorial>

    //Fetch album by its ID
    suspend fun fetchAlbum(albumId: Int): Flow<Album>

    //Fetch an artist by his/her ID
    suspend fun fetchArtist(artistId:Int):Flow<Artist>

    //Fetch a track by its ID
    suspend fun fetchTrack(trackID: Int): Flow<Track>
}