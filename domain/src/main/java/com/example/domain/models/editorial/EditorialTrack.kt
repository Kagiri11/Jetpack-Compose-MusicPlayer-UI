package com.example.domain.models.editorial

data class EditorialTrack(
    val album: EditorialAlbum,
    val artist: EditorialTrackArtist,
    val duration: Int,
    val explicitContentCover: Int,
    val explicitContentLyrics: Int,
    val explicitLyrics: Boolean,
    val id: Long,
    val link: String,
    val md5Image: String,
    val position: Int,
    val preview: String,
    val rank: Int,
    val title: String,
    val titleShort: String,
    val titleVersion: String,
    val type: String
)