package com.example.domain.models.album

data class Artist(
    val id: Int,
    val name: String,
    val picture: String?=null,
    val picture_big: String?=null,
    val picture_medium: String?=null,
    val picture_small: String?=null,
    val picture_xl: String?=null,
    val tracklist: String,
    val type: String
)