package com.example.albums

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.albums.ui.theme.AlbumsTheme
import com.example.common.DataState
import com.example.presentation.model.AlbumUi
import com.example.presentation.view.AlbumsScreen
import com.example.presentation.viewmodel.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbumsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val albumsViewModel: AlbumsViewModel = hiltViewModel()
                    val uiState: DataState<List<AlbumUi>> by albumsViewModel.uiState.collectAsState()
                    AlbumsScreen(uiState)
                }
            }
        }
    }
}
