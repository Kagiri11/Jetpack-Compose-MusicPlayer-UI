package com.example.domain.models.editorial

data class EditorialArtist(
    val id: Int,
    val link: String,
    val name: String,
    val picture: String,
    val pictureBig: String,
    val pictureMedium: String,
    val pictureSmall: String,
    val pictureXl: String,
    val position: Int,
    val radio: Boolean,
    val trackList: String,
    val type: String
)