package com.example.musiclistener.playlist.controller
import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.model.PlaylistWithSongs
import com.example.musiclistener.playlist.services.PlaylistService
import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
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

    @DeleteMapping("/{id}/{songId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteSongFromPlaylist(@PathVariable id: Int, @PathVariable songId: Int): Mono<Void> {
       return playlistService.deleteSongFromPlaylist(id, songId)
    }

}