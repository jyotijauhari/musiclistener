package com.example.musiclistener.previous.controller

import com.example.musiclistener.previous.model.MusicPlayerModel
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

class WebClientAPI {

    //create web client instance
    private val webClient:WebClient = WebClient.create("http://localhost:8080");

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
}