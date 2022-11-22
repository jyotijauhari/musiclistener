package com.example.musiclistener.playlist_songs.controller

import com.example.musiclistener.playlist.services.PlaylistService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureMockMvc
class PlaylistSongsControllerTest{
    @Autowired
    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun initClient(context: ApplicationContext) {
        webTestClient = WebTestClient
            .bindToApplicationContext(context)
            .build()
    }

    @Test
    fun shouldReturnAllPlaylistIdAndSongIdWhenGetPlaylistSongEndpointIsCalled() {
        webTestClient.get()
            .uri("/playlistsong")
            .exchange()
            .expectStatus().is2xxSuccessful

    }

    @Test
    fun shouldReturn404ErrorWhenGetWrongEndpointIsCalled() {
        webTestClient.get()
            .uri("/playlistsongg")
            .exchange()
            .expectStatus().is4xxClientError

    }
}
