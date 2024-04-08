package com.example.presentation.model

import com.example.domain.model.AlbumModel

data class AlbumUi(
    val id: String,
    val albumId: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
) {
    companion object {
        fun mapToAlbumUi(albumModel: AlbumModel): AlbumUi {
            return AlbumUi(
                id = albumModel.id ?: "Not defined",
                albumId = albumModel.albumId ?: "Not defined",
                title = albumModel.title ?: "Not defined",
                url = albumModel.url ?: "Not defined",
                thumbnailUrl = albumModel.thumbnailUrl ?: "Not defined",
            )
        }
    }
}
