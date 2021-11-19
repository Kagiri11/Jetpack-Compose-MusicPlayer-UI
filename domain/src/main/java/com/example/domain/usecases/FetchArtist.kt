package com.example.domain.usecases

import com.example.domain.models.album.Artist
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class FetchArtist(private val repository: AppRepository) {
    suspend operator fun invoke(artistId: Int): Flow<Artist> {
        return repository.fetchArtist(artistId)
    }
}