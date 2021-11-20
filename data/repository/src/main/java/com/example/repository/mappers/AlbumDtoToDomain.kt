package com.example.repository.mappers


import com.example.domain.models.album.*
import com.example.network.models.album.*


fun AlbumDto.toDomain(): Album {
    return Album(
        artist = artist.toDomain(),
        available = available,
        contributors = contributors.map { it.toDomain() },
        genres = genres.toDomain(),
        tracks = tracks.toDomain(),
        cover_big = cover_big,
        cover_medium = cover_medium,
        cover = cover,
        cover_small = cover_small,
        duration = duration,
        cover_xl = cover_xl,
        id = id,
        fans = fans,
        genre_id = genre_id,
        link = link,
        md5_image = md5_image,
        nb_tracks = nb_tracks,
        record_type = record_type,
        release_date = release_date,
        title = title,
        tracklist = tracklist,
        type = type
    )
}

fun AlbumArtistDto.toDomain(): AlbumArtist {
    return AlbumArtist(
        id, name, picture, picture_big, picture_medium, picture_small, picture_xl, tracklist, type
    )
}

fun AlbumContributorDto.toDomain(): AlbumContributor {
    return AlbumContributor(
        id,
        link,
        name,
        picture,
        picture_big,
        picture_medium,
        picture_small,
        picture_xl,
        radio,
        role,
        share,
        tracklist,
        type
    )
}

fun AlbumGenreDto.toDomain(): AlbumGenre {
    return AlbumGenre(
        id, name, picture, type
    )
}

fun AlbumGenresDto.toDomain(): AlbumGenres {
    return AlbumGenres(
        data = data.map { it.toDomain() }
    )
}

fun AlbumTrackDto.toDomain(): AlbumTrack {
    return AlbumTrack(
        artist = artist.toDomain(),
        duration,
        explicit_content_cover,
        explicit_content_lyrics,
        explicit_lyrics,
        id,
        link,
        md5_image,
        preview,
        rank,
        readable,
        title,
        title_short,
        title_version,
        type
    )
}

fun AlbumTracksDto.toDomain(): AlbumTracks {
    return AlbumTracks(
        data = data.map { it.toDomain() }
    )
}

fun AlbumTrackArtistDto.toDomain(): AlbumTrackArtist {
    return AlbumTrackArtist(
        id, name, tracklist, type
    )
}