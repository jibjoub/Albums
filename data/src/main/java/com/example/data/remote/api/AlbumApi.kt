package com.example.data.remote.api

import com.example.data.entity.AlbumEntity
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApi {
    @GET("img/shared/technical-test.json")
    suspend fun getAlbums(): Response<List<AlbumEntity>>
}
