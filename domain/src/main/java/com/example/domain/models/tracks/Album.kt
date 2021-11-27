package com.example.domain.models.tracks

data class Album(
    val cover: String?=null,
    val cover_big: String?=null,
    val cover_medium: String?=null,
    val cover_small:String?=null,
    val cover_xl: String?=null,
    val id: Int,
    val md5_image: String?=null,
    val title: String?=null,
    val tracklist: String?=null,
    val type: String
)