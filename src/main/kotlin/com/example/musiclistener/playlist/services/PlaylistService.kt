package com.example.musiclistener.playlist.services

import com.example.musiclistener.playlist.model.Playlist
import com.example.musiclistener.playlist.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class PlaylistService(
    val playlistRepository: PlaylistRepository
) {
    fun getAllPlaylist(): Flux<Playlist> {
        return playlistRepository.findAll()
    }
}