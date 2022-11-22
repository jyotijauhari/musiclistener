package com.example.musiclistener.playlist.controller

import com.example.musiclistener.playlist.model.MusicPlayerModel
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class WebClientAPI {

    //create web client instance
    private val webClient:WebClient = WebClient.create("http://localhost:8081")

    //prepare request

    //read response
    fun getAllSongs(): Flux<MusicPlayerModel> {
        return webClient
            .get()
            .uri("/songs")
            .retrieve()
            .bodyToFlux(MusicPlayerModel::class.java)
            .doOnNext{ println("inside getAllSongs: $it") }
    }

    fun getSongById(id: Int): Mono<MusicPlayerModel> {
        return webClient
            .get()
            .uri("/songs/{id}",id)
            .retrieve()
            .bodyToMono(MusicPlayerModel::class.java)
            .doOnNext{ println("inside getSongsById: $it") }
    }
}