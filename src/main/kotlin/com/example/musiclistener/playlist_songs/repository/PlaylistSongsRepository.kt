package com.example.musiclistener.playlist_songs.repository

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface PlaylistSongsRepository : ReactiveCrudRepository<PlaylistSongs, Int> {

    @Query("select * from playlist_songs where playlist_id=?")
    fun findSongIdsByPlaylistId(pid: Int): Flux<PlaylistSongs>

    fun findAllByPlaylistId(playlistId: Int): Flux<PlaylistSongs>
    fun findByPlaylistIdAndSongId(playlistId: Int, songId: Int): Mono<PlaylistSongs>

}