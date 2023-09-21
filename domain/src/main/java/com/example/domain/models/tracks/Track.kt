package com.example.domain.models.tracks

data class Track(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val id: Long,
    val link: String?=null,
    val md5Image: String?=null,
    val preview: String?=null,
    val title: String?=null,
    val titleShort: String?=null,
    val titleVersion: String?=null,
)