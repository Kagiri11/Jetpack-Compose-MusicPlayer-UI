package com.example.domain.models.editorial

import com.example.domain.models.album.Tracks

data class Editorial(
    val albums: Albums,
    val artists: Artists,
    val playlists: Playlists,
    val tracks: Tracks
)