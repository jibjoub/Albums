package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.DataState
import com.example.common.DataState.Loading.mapData
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.presentation.model.AlbumUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel
    @Inject
    constructor(getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {
        val uiState: StateFlow<DataState<List<AlbumUi>>> =
            getAlbumsUseCase().map { state ->
                state.mapData { albumModels -> albumModels.map { AlbumUi.mapToAlbumUi(it) } }
            }.stateIn(
                initialValue = DataState.Loading,
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
            )
    }
