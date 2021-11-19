package com.example.domain.usecases

import com.example.domain.models.editorial.Editorial
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class FetchEditorial(private val repository: AppRepository) {
    suspend operator fun invoke(): Flow<Editorial>{
        return repository.fetchEditorial()
    }
}