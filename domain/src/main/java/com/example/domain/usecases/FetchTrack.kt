package com.example.domain.usecases

import com.example.domain.models.album.Track
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class FetchTrack(private val repository: AppRepository) {
    suspend operator fun invoke(trackId: Int): Flow<Track>{
        return repository.fetchTrack(trackId)
    }
}