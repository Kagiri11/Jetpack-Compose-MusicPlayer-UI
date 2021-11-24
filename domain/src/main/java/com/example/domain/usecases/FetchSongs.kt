package com.example.domain.usecases

import com.example.domain.models.tracks.Tracks
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class FetchSongs(private val repository: AppRepository) {
    suspend operator fun invoke(): Flow<Tracks> {
        return repository.fetchSongs()
    }
}