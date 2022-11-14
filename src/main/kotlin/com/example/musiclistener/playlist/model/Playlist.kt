package com.example.musiclistener.playlist.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import reactor.core.publisher.Flux
import java.sql.Date

@Table
class Playlist(
    @Id
    val id: Int?,
    val name: String,
    val created_at: Date,
){
}
