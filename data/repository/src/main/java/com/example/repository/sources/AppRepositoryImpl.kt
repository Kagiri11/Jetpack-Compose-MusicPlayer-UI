package com.example.repository.sources

import com.example.domain.models.album.Album
import com.example.domain.models.editorial.Editorial
import com.example.domain.models.tracks.Tracks
import com.example.domain.repository.AppRepository
import com.example.network.apis.ApiService
import com.example.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AppRepositoryImpl(private val api: ApiService): AppRepository {
    override suspend fun fetchEditorial(): Flow<Editorial> {
        val editorials = api.getEditorsChoices()
        return flowOf(editorials.toDomain())
    }

    override suspend fun fetchAlbum(albumId:Int): Flow<Album> {
        val album = api.fetchAlbum(albumId)
       return flowOf(album.toDomain())
    }

    override suspend fun fetchSongs(): Flow<Tracks> {
        val tracks = api.fetchSongs()
        return flowOf(tracks.toDomain())
    }
//    override suspend fun fetchArtist(artistId: Int): Flow<Artist> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun fetchTrack(trackID: Int): Flow<Track> {
//        TODO("Not yet implemented")
//    }
}