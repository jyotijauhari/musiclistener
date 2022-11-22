package com.example.musiclistener.playlist.controller

import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.model.PlaylistWithSongs
import com.example.musiclistener.playlist.services.PlaylistService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/playlist")
class PlaylistController(
    val playlistService: PlaylistService
) {
    @GetMapping
    fun getAllPlaylist(): Flux<Playlist> {
        return playlistService.getAllPlaylist()
    }

    @GetMapping("/{id}")
    fun getPlaylistDetails(@PathVariable id: Int): Mono<PlaylistWithSongs> {
        return playlistService.getPlaylistDetails(id)
    }

    @DeleteMapping("/{id}/{songId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteSongFromPlaylist(@PathVariable id: Int, @PathVariable songId: Int): Mono<Void> {
        return playlistService.deleteSongFromPlaylist(id, songId)
    }

}