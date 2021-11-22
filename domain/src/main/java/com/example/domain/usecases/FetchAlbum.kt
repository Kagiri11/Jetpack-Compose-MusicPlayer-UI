package com.example.domain.usecases

import com.example.domain.models.album.Album
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FetchAlbum(private val repository: AppRepository) {
    suspend operator fun invoke(albumId:Int): Flow<Album> {
        return repository.fetchAlbum(albumId)
    }
}