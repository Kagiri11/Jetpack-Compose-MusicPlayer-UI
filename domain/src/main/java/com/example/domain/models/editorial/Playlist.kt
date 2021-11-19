package com.example.domain.models.editorial

data class Playlist(
    val id: Int,
    val link: String,
    val md5_image: String,
    val nb_tracks: Int,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val title: String,
    val tracklist: String,
    val type: String,
    val user: User
)