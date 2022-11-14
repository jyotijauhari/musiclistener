package com.example.musiclistener.playlist.services

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import com.example.musiclistener.playlist.repository.PlaylistSongsRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class PlaylistSongsService(
    val playlistSongsRepository: PlaylistSongsRepository
) {

    fun getAllPlaylistSongs(): Flux<PlaylistSongs> {
        return playlistSongsRepository.findAll()
    }

    fun getSongIds(playlistId: Int): Flux<Int> {
        val songIds = playlistSongsRepository.findAllByPlaylistId(playlistId)
            .map { it.songId }
        return songIds;
    }
}