package com.example.network.models.editorial

data class EditorialDto(
    val albums: Albums,
    val artists: ArtistsDto,
    val playlists: PlaylistsDto,
    val podcasts: PodcastsDto,
    val tracks: TracksDto
)