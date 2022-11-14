package com.example.musiclistener.playlist.repository

import com.example.musiclistener.playlist.model.Playlist
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PlaylistRepository : ReactiveCrudRepository<Playlist,Int> {

    @Query("select * from playlist where name=?")
    fun findSongIdsByPlaylistId(name:String): Flux<Playlist>

    fun findByName(name: String) : Mono<Playlist>

    fun findAllByName(name: String) : Flux<Playlist>

}