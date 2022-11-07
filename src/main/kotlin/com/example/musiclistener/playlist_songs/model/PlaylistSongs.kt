package com.example.musiclistener.playlist.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table
data class PlaylistSongs(
    @Id
    val id: Int? ,
    val playlistId: Int,
    val songId: Int
)
