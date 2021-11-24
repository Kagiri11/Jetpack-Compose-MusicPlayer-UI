package com.example.network.models.tracks

data class Tracks(
    val checksum: String,
    val `data`: List<Data>,
    val next: String,
    val total: Int
)