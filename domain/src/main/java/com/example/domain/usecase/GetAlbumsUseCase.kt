package com.example.domain.usecase

import com.example.common.DataState
import com.example.domain.model.AlbumModel
import com.example.domain.repository.AlbumsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlbumsUseCase
    @Inject
    constructor(private val albumsRepository: AlbumsRepository) {
        operator fun invoke(): Flow<DataState<List<AlbumModel>>> = albumsRepository.getAlbums()
    }
