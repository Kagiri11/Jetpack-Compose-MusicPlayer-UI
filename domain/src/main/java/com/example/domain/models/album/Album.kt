package com.example.domain.models.album

data class Album(
    val artist: AlbumArtist,
    val available: Boolean,
    val contributors: List<AlbumContributor>,
    val cover: String,
    val coverBig: String,
    val coverMedium: String,
    val coverSmall: String,
    val coverXl: String,
    val duration: Int,
    val fans: Int,
    val genreId: Int,
    val genres: AlbumGenres,
    val id: Int,
    val link: String,
    val md5Image: String,
    val nbTracks: Int,
    val recordType: String,
    val releaseDate: String,
    val title: String,
    val trackList: String,
    val tracks: AlbumTracks,
    val type: String,
)