package com.example.musiclistener.playlist_songs.model

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
data class NotFoundException(val msg: String) : RuntimeException(msg)