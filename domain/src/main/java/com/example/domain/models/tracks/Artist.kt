package com.example.domain.models.tracks

data class Artist(
    val id: Long,
    val link: String?=null,
    val name: String?=null,
    val picture: String?=null,
    val pictureBig: String?=null,
    val pictureMedium: String?=null,
    val pictureSmall: String?=null,
    val pictureXl: String?=null,
    val trackList: String?=null,
    val type: String
)