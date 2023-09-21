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
        coverBig = cover_big,
        coverMedium = cover_medium,
        cover = cover,
        coverSmall = cover_small,
        duration = duration,
        coverXl = cover_xl,
        id = id,
        fans = fans,
        genreId = genre_id,
        link = link,
        md5Image = md5_image,
        nbTracks = nb_tracks,
        recordType = record_type,
        releaseDate = release_date,
        title = title,
        trackList = tracklist,
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