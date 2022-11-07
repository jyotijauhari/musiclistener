package com.example.musiclistener.playlist.controller

import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.services.PlaylistService
import com.example.musiclistener.playlist.services.PlaylistSongsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/playlist")
class PlaylistController(
    val playlistService: PlaylistService
) {
    @GetMapping
    fun getAllPlaylist(): Flux<Playlist> {
        return playlistService.getAllPlaylist();
    }

    @GetMapping("/name")
    fun abcd(): Mono<Playlist> {
        println("in abcd")
        return playlistService.getPlaylistByName()
    }

    @GetMapping("/allname")
    fun pqrs(): Flux<Playlist> {
        println("in pqrs")
        return playlistService.getAllPlaylistByName()
    }

}