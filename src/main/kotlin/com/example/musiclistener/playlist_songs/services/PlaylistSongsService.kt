package com.example.musiclistener.playlist_songs.services

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import com.example.musiclistener.playlist_songs.repository.PlaylistSongsRepository
import com.example.musiclistener.playlist_songs.model.NotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlaylistSongsService(
    val playlistSongsRepository: PlaylistSongsRepository
) {

    fun getAllPlaylistSongs(): Flux<PlaylistSongs> {
        return playlistSongsRepository.findAll()
    }

    fun getSongsId(playlistId: Int): Flux<Int> {
        return playlistSongsRepository
            .findAllByPlaylistId(playlistId)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("User with $playlistId not found")
                )
            )
            .map { it.songId }
    }

    fun deleteSongFromPlaylist(playlistId: Int, songId: Int): Mono<Void> {
        return playlistSongsRepository
            .findByPlaylistIdAndSongId(playlistId, songId)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("Song with song id: $songId not found")
                )
            )
            .flatMap { data -> playlistSongsRepository.delete(data) }
    }
}