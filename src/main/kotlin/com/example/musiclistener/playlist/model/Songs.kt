package com.example.musiclistener.playlist.model

import reactor.core.publisher.Flux

class Songs(val songs: Flux<MusicPlayerModel>) {
}