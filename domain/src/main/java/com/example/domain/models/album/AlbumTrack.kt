package com.example.domain.models.album

data class AlbumTrack(
    val artist: AlbumTrackArtist,
    val duration: Int,
    val explicitContentCover: Int,
    val explicitContentLyrics: Int,
    val explicitLyrics: Boolean,
    val id: Long,
    val link: String,
    val md5Image: String,
    val preview: String,
    val rank: Int,
    val readable: Boolean,
    val title: String,
    val titleShort: String,
    val titleVersion: String,
    val type: String
)