package com.example.network.models.tracks

data class TrackAlbumDto(
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val id: Long,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String
)