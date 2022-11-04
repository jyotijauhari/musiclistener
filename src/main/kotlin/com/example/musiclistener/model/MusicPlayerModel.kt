package com.example.musiclistener.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Id

data class MusicPlayerModel(
    val id: Int,
    val name: String,
    val composer: String,
    val language: String,
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    val releaseDate: Date,
) {
}