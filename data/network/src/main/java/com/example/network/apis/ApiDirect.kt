package com.example.network.apis

import com.example.network.models.tracks.TracksDto
import retrofit2.http.GET

interface ApiDirect {

    @GET("9666268482/tracks?index=2")
    suspend fun fetchSongs(): TracksDto

}