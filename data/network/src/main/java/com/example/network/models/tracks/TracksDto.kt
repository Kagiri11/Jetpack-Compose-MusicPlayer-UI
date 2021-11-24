package com.example.network.models.tracks

data class TracksDto(
    val checksum: String,
    val `data`: List<TrackDto>,
    val next: String,
    val total: Int
)