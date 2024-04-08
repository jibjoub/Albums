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
        id = this.id,
        albumId = this.albumId,
        title = this.title,
        url = this.url,
        thumbnailUrl = this.thumbnailUrl,
    )
}
