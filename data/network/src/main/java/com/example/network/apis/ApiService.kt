package com.example.network.apis

import com.example.network.models.album.AlbumDto
import com.example.network.models.editorial.EditorialAlbumDto
import com.example.network.models.editorial.EditorialDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("editorial/0/charts")
    suspend fun getEditorsChoices():EditorialDto

    @GET("album/{albumID}")
    suspend fun fetchAlbum(
        albumID: Int = 302127
    ):AlbumDto
}