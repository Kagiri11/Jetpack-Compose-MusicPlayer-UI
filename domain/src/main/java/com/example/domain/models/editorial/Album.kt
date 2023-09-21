package com.example.domain.models.editorial

data class Album(
    val artist: EditorialAlbumArtist,
    val cover: String,
    val coverBig: String,
    val coverMedium: String,
    val coverSmall: String,
    val coverXl: String,
    val explicitLyrics: Boolean,
    val id: Int,
    val link: String,
    val md5Image: String,
    val position: Int,
    val recordType: String,
    val title: String,
    val trackList: String,
    val type: String
)