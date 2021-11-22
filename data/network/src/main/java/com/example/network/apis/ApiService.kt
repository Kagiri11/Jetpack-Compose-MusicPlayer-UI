package com.example.network.apis

import com.example.network.models.album.AlbumDto
import com.example.network.models.editorial.EditorialAlbumDto
import com.example.network.models.editorial.EditorialDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("editorial/0/charts")
    suspend fun getEditorsChoices():EditorialDto

    @GET("album/{id}")
    suspend fun fetchAlbum(
        @Path("id") albumId:Int
    ):AlbumDto
}