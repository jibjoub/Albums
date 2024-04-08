package com.example.domain.repository

import com.example.common.DataState
import com.example.domain.model.AlbumModel
import kotlinx.coroutines.flow.Flow

interface AlbumsRepository {
    fun getAlbums(): Flow<DataState<List<AlbumModel>>>
}