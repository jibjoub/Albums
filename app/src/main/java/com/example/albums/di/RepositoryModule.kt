package com.example.albums.di

import com.example.data.repository.AlbumsRepositoryImpl
import com.example.domain.repository.AlbumsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAlbumsRepository(albumsRepositoryImpl: AlbumsRepositoryImpl): AlbumsRepository
}
