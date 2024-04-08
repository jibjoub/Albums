package com.example.data.repository

import com.example.common.DataState
import com.example.data.remote.api.AlbumApi
import com.example.domain.model.AlbumModel
import com.example.domain.repository.AlbumsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumsRepositoryImpl
    @Inject
    constructor(private val albumApi: AlbumApi) : AlbumsRepository {
        override fun getAlbums(): Flow<DataState<List<AlbumModel>>> {
            TODO("Not yet implemented")
        }
    }
