package com.example.domain.models.tracks

data class Album(
    val cover: String?=null,
    val coverBig: String?=null,
    val coverMedium: String?=null,
    val coverSmall:String?=null,
    val coverXl: String?=null,
    val id: Long,
    val md5Image: String?=null,
    val title: String?=null,
    val trackList: String?=null,
    val type: String
)