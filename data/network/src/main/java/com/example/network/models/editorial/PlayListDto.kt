package com.example.network.models.editorial

data class PlayListDto(
    val checksum: String,
    val creation_date: String,
    val id: Int,
    val link: String,
    val md5_image: String,
    val nb_tracks: Int,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val picture_type: String,
    val picture_xl: String,
    val `public`: Boolean,
    val title: String,
    val tracklist: String,
    val type: String,
    val user: UserDto
)