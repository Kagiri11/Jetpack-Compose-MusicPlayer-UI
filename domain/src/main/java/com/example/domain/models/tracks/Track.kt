package com.example.domain.models.tracks

data class Track(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val id: Int,
    val link: String?=null,
    val md5_image: String?=null,
    val preview: String?=null,
    val title: String?=null,
    val title_short: String?=null,
    val title_version: String?=null,
)