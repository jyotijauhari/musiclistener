package com.example.musiclistener.previous.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class MusicPlayerModel(
    val id: Int,
    val name: String,
    val composer: String,
    val language: String,
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    val releaseDate: Date,
) {
}