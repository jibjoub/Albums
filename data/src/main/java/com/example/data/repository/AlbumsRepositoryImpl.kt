package com.example.data.repository

import com.example.common.DataState
import com.example.data.entity.mapToAlbumModel
import com.example.data.remote.api.AlbumApi
import com.example.domain.model.AlbumModel
import com.example.domain.repository.AlbumsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlbumsRepositoryImpl
    @Inject
    constructor(private val albumApi: AlbumApi) : AlbumsRepository {
        override fun getAlbums(): Flow<DataState<List<AlbumModel>>> =
            flow { emit(albumApi.getAlbums()) }.map { response ->
                if (response.isSuccessful.not()) {
                    return@map DataState.Error(Exception("Response is not successful. Code: ${response.code()}"))
                }
                val body = response.body()
                if (body.isNullOrEmpty()) {
                    return@map DataState.Error(Exception("Response body is null or empty"))
                } else {
                    return@map DataState.Success(body.map { it.mapToAlbumModel() })
                }
            }.catch {
                DataState.Error(Exception(it))
            }
    }
