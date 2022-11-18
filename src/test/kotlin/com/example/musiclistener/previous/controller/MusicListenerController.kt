package com.example.musiclistener.previous.controller

import com.example.musiclistener.playlist_songs.services.PlaylistSongsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/playlist")
class MusicListenerController(
    @Autowired
    val playlistSongsService: PlaylistSongsService
) {
//    @GetMapping
//    fun getAllPlaylist(): Flux<Playlist> {
//        return playlistService.getAllPlaylist();
//    }

//    @GetMapping
//    fun abcd(): Flux<Int> {
//        println("in abcd")
//        return playlistSongsService.getAllSongsWithSamePlaylistId(1);
//    }



}