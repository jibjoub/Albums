package com.example.data.repository

import com.example.common.DataState
import com.example.data.entity.AlbumEntity
import com.example.data.remote.api.AlbumApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class AlbumsRepositoryImplTest {
    private lateinit var albumApi: AlbumApi
    private lateinit var albumRepository: AlbumsRepositoryImpl

    @Before
    fun setup() {
        albumApi = mockk()
        albumRepository = AlbumsRepositoryImpl(albumApi)
    }

    @Test
    fun `Given a valid flow of data from Retrofit Instance, when we call getAlbums, then it should emit Success data state with correct data`() {
        runBlocking {
            val albumsResponse = listOf(AlbumEntity("test", "test", "test", "test", "test"))
            coEvery { albumApi.getAlbums() } returns Response.success(albumsResponse)

            albumRepository.getAlbums().collect { dataState ->
                Assert.assertTrue(dataState is DataState.Success)
            }
        }
    }
}
