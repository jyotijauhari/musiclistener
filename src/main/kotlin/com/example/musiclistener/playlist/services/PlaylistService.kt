package com.example.musiclistener.playlist.services

import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.repository.PlaylistRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlaylistService(
    val playlistRepository: PlaylistRepository
) {
     fun getAllPlaylist(): Flux<Playlist> {
         println("get all --------> "  + playlistRepository.findAll())
//        val ans = getAllSongsWithSamePlaylistId(myfav)
//         val list1: List<Int> = ans.collectList().block() as List<Int>
//         list1.forEach(System.out::println)

        return playlistRepository.findAll()
    }

    fun getPlaylistByName(): Mono<Playlist> {
        return playlistRepository.findByName("travel")
    }

    fun getAllPlaylistByName(): Flux<Playlist> {
        return playlistRepository.findAllByName("travel")
    }

}