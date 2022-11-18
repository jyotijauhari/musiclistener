package com.example.musiclistener.playlist_songs.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class PlaylistSongs(
    @Id
    val id: Int? ,
    val playlistId: Int,
    val songId: Int
)
