package com.example.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.model.AlbumUi

@Composable
fun AlbumList(albums: List<AlbumUi>) {
    LazyColumn {
        items(albums) { album ->
            AlbumItem(album = album)
        }
    }
}

@Composable
fun AlbumItem(album: AlbumUi) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        // Thumbnail
        AsyncImageSvg(
            album.thumbnailUrl,
            Modifier
                .size(64.dp)
                .align(Alignment.CenterVertically),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            // AlbumId
            Text(text = album.albumId, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            // Title
            Text(text = album.title, fontWeight = FontWeight.Medium, fontSize = 14.sp)
        }
    }
}
