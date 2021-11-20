package com.example.network.models.editorial

data class EditorialDto(
    val albums: AlbumsDto,
    val artists: EditorialArtistsDto,
    val playlists: Playlists,
    val podcasts: Podcasts,
    val tracks: EditorialTracksDto
)