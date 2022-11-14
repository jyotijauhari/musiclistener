package com.example.musiclistener.playlist.controller
import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.model.PlaylistWithSongs
import com.example.musiclistener.playlist.services.PlaylistService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/{id}")
    fun getPlaylistDetails(@PathVariable id:Int): Mono<PlaylistWithSongs> {
         return playlistService.getPlaylistDetails(id);
    }

}