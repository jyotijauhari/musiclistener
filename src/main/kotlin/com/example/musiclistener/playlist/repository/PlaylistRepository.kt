package com.example.musiclistener.playlist.repository

import com.example.musiclistener.playlist.model.Playlist
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PlaylistRepository : ReactiveCrudRepository<Playlist,Int> {
}