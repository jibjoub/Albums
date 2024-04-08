package com.example.data.entity

import com.example.domain.model.AlbumModel

data class AlbumEntity(
    val id: String?,
    val albumId: String?,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?,
)

fun AlbumEntity.mapToAlbumModel(): AlbumModel {
    return AlbumModel(
        id = null,
        albumId = null,
        title = null,
        url = null,
        thumbnailUrl = null,
    )
}
