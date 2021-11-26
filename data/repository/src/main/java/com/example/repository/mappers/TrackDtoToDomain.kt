package com.example.repository.mappers

import com.example.domain.models.tracks.Album
import com.example.domain.models.tracks.Artist
import com.example.domain.models.tracks.Track
import com.example.domain.models.tracks.Tracks
import com.example.network.models.tracks.TrackAlbumDto
import com.example.network.models.tracks.TrackArtistDto
import com.example.network.models.tracks.TrackDto
import com.example.network.models.tracks.TracksDto

internal fun TracksDto.toDomain(): Tracks {
    return Tracks(
        checksum = checksum,
        data = data.map { it.toDomain() },
        next = next,
        total = total
    )
}

internal fun TrackDto.toDomain(): Track {
    return Track(
        album = album.toDomain(),
        artist = artist.toDomain(),
        duration,
        id,
        link,
        md5_image,
        preview,
        title,
        title_short,
        title_version
    )
}

internal fun TrackAlbumDto.toDomain(): Album {
    return Album(
        cover,
        cover_big,
        cover_medium,
        cover_small,
        cover_xl,
        id,
        md5_image,
        title,
        tracklist,
        type
    )
}

internal fun TrackArtistDto.toDomain(): Artist {
    return Artist(
        id,
        link,
        name,
        picture,
        picture_big,
        picture_medium,
        picture_small,
        picture_xl,
        tracklist,
        type
    )
}