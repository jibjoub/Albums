package com.example.data.repository

import com.example.common.DataState
import com.example.data.entity.AlbumEntity
import com.example.data.remote.api.AlbumApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class AlbumsRepositoryImplTest {
    private lateinit var albumApi: AlbumApi
    private lateinit var albumsRepository: AlbumsRepositoryImpl

    @Before
    fun setup() {
        albumApi = mockk()
        albumsRepository = AlbumsRepositoryImpl(albumApi)
    }

    @Test
    fun `Given a valid flow of data from Retrofit Instance, when we call getAlbums, then it should emit Success data state with correct data`() {
        runBlocking {
            val albumsResponse = listOf(AlbumEntity("test", "test", "test", "test", "test"))
            coEvery { albumApi.getAlbums() } returns Response.success(albumsResponse)

            albumsRepository.getAlbums().collect { dataState ->
                assert(dataState is DataState.Success)
            }
        }
    }

    @Test
    fun `Given an error from the Retrofit Instance response, when we call getWorldCountries, then it should emit Error data state`() {
        runBlocking {
            coEvery { albumApi.getAlbums() } returns Response.error(400, ResponseBody.create(null, "test"))
            albumsRepository.getAlbums().collect { dataState ->
                assert(dataState is DataState.Error)
            }
        }
    }

    @Test
    fun `Given a null body from the Retrofit Instance response, when we call getWorldCountries, then it should emit Error data state`() {
        runBlocking {
            coEvery { albumApi.getAlbums() } returns Response.success(null)
            albumsRepository.getAlbums().collect { dataState ->
                assert(dataState is DataState.Error)
            }
        }
    }
}
