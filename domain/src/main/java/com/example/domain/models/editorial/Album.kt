package com.example.domain.models.editorial

data class Album(
    val artist: EditorialAlbumArtist,
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val explicit_lyrics: Boolean,
    val id: Int,
    val link: String,
    val md5_image: String,
    val position: Int,
    val record_type: String,
    val title: String,
    val tracklist: String,
    val type: String
)