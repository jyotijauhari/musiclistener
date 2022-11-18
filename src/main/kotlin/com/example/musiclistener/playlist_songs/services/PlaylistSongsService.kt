package com.example.musiclistener.playlist_songs.services

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import com.example.musiclistener.playlist.repository.PlaylistSongsRepository
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

    fun getSongIds(playlistId: Int): Flux<Int> {
        val songIds = playlistSongsRepository.findAllByPlaylistId(playlistId)
            .map { it.songId }
        return songIds;
    }

    fun deleteSongFromPlaylist(playlistId: Int, songId: Int): Mono<Void> {
        return  playlistSongsRepository
            .findByPlaylistIdAndSongId(playlistId, songId)
            .log()
            .flatMap{data -> playlistSongsRepository.delete(data)}
    }
}