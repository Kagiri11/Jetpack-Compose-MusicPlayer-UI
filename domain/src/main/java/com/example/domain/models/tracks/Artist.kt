package com.example.domain.models.tracks

data class Artist(
    val id: Long,
    val link: String?=null,
    val name: String?=null,
    val picture: String?=null,
    val picture_big: String?=null,
    val picture_medium: String?=null,
    val picture_small: String?=null,
    val picture_xl: String?=null,
    val tracklist: String?=null,
    val type: String
)