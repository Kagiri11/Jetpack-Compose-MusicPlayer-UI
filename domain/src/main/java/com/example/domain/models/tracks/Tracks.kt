package com.example.domain.models.tracks

data class Tracks(
    val checksum: String,
    val `data`: List<Track>,
    val next: String,
    val total: Int
)