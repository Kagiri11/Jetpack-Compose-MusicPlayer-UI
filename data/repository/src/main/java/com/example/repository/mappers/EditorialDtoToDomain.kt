package com.example.repository.mappers

import com.example.domain.models.editorial.*
import com.example.network.models.editorial.*

internal fun EditorialArtistDto.toDomain(): EditorialArtist {
    return EditorialArtist(
        id,
        link,
        name,
        picture,
        picture_big,
        picture_medium,
        picture_small,
        picture_xl,
        position,
        radio,
        tracklist,
        type
    )
}

internal fun EditorialArtistsDto.toDomain(): EditorialArtists {
    return EditorialArtists(
        data = data.map { it.toDomain() },
        total
    )
}

internal fun EditorialAlbumDto.toDomain(): EditorialAlbum {
    return EditorialAlbum(
        cover, cover_big, cover_medium, cover_small, cover_xl, id, md5_image, title, tracklist, type
    )
}

internal fun EditorialAlbumArtistDto.toDomain(): EditorialAlbumArtist {
    return EditorialAlbumArtist(
        id,
        link,
        name,
        picture,
        picture_big,
        picture_medium,
        picture_small,
        picture_xl,
        radio,
        tracklist,
        type
    )
}

internal fun EditorialDto.toDomain(): Editorial {
    return Editorial(
        albums = albums.toDomain(),
        artists = artists.toDomain(),
        tracks = tracks.toDomain()
    )
}

internal fun AlbumsDto.toDomain(): Albums {
    return Albums(
        data = data.map { it.toDomain() }, total
    )
}

internal fun AlbumDto.toDomain(): Album {
    return Album(
        artist = artist.toDomain(),
        cover,
        cover_big,
        cover_medium,
        cover_small,
        cover_xl,
        explicit_lyrics,
        id,
        link,
        md5_image,
        position,
        record_type,
        title,
        tracklist,
        type
    )
}

internal fun EditorialTracksDto.toDomain(): EditorialTracks {
    return EditorialTracks(
        data = data.map { it.toDomain() },
        total
    )
}

internal fun EditorialTrackDto.toDomain(): EditorialTrack {
    return EditorialTrack(
        album = album.toDomain(),
        artist = artist.toDomain(),
        duration = duration,
        explicitContentCover = explicit_content_cover,
        explicitContentLyrics = explicit_content_lyrics,
        explicitLyrics = explicit_lyrics,
        id = id,
        link = link,
        md5Image = md5_image,
        position = position,
        preview = preview,
        rank = rank,
        title = title,
        titleShort = title_short,
        titleVersion = title_version,
        type = type
    )
}

internal fun EditorialTrackArtistDto.toDomain(): EditorialTrackArtist {
    return EditorialTrackArtist(
        id,
        link,
        name,
        picture,
        picture_big,
        picture_medium,
        picture_small,
        picture_xl,
        radio,
        tracklist,
        type
    )
}