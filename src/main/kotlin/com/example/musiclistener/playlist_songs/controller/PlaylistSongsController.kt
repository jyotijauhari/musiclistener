package com.example.musiclistener.playlist.controller

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import com.example.musiclistener.playlist_songs.services.PlaylistSongsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/playlistsong")
class PlaylistSongsController(
    val playlistSongsService: PlaylistSongsService
) {
    @GetMapping
    fun getAllPlaylist(): Flux<PlaylistSongs> {
        return playlistSongsService.getAllPlaylistSongs();
    }

    @GetMapping("/{id}")
    fun getSongIds(@PathVariable id:Int): Flux<Int> {
        return playlistSongsService.getSongIds(id);
    }

}