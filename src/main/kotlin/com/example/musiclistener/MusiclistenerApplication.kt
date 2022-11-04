package com.example.musiclistener
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Metrics.URI


@SpringBootApplication
class MusiclistenerApplication

fun main(args: Array<String>) {
	runApplication<MusiclistenerApplication>(*args)

//	val api = WebClientAPI()
//
//	api.getAllSongs()
//		.subscribe()
}
