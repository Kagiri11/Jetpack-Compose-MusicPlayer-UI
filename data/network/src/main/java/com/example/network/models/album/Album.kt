package com.example.network.models.album

data class Album(
    val artist: Artist,
    val available: Boolean,
    val contributors: List<ContributorDto>,
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val duration: Int,
    val explicit_content_cover: Int,
    val explicit_content_lyrics: Int,
    val explicit_lyrics: Boolean,
    val fans: Int,
    val genre_id: Int,
    val genres: GenresDto,
    val id: Int,
    val label: String,
    val link: String,
    val md5_image: String,
    val nb_tracks: Int,
    val record_type: String,
    val release_date: String,
    val share: String,
    val title: String,
    val tracklist: String,
    val tracks: TracksDto,
    val type: String,
    val upc: String
)