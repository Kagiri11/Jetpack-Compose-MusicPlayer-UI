package com.example.domain.models.tracks

data class Track(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val id: Int,
    val link: String,
    val md5_image: String,
    val preview: String,
    val title: String,
    val title_short: String,
    val title_version: String,
)