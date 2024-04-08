package com.example.data.entity

import com.example.domain.model.AlbumModel
import junit.framework.TestCase
import org.junit.Test

class AlbumEntityTest {
    @Test
    fun `Given an AlbumEntity, when mapping to AlbumModel, the fields should be correctly mapped`() {
        val albumEntity = AlbumEntity("1", "2", "Title", "url1", "url2")
        val albumModelExpected = AlbumModel("1", "2", "Title", "url1", "url2")

        val res = albumEntity.mapToAlbumModel()

        TestCase.assertEquals(albumModelExpected, res)
    }
}
