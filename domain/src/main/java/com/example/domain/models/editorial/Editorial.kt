package com.example.domain.models.editorial

data class Editorial(
    val albums: Albums,
    val artists: EditorialArtists,
    val tracks: EditorialTracks
)