package com.example.musiclistener.playlist.repository

import com.example.musiclistener.playlist_songs.model.PlaylistSongs
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PlaylistSongsRepository : ReactiveCrudRepository<PlaylistSongs,Int> {

    @Query("select * from playlist_songs where playlist_id=?")
    fun findSongIdsByPlaylistId(pid:Int): Flux<PlaylistSongs>

    fun findAllByPlaylistId(playlistId: Int) : Flux<PlaylistSongs>

}