package com.example.musiclistener.playlist.model

import java.sql.Date

data class PlaylistWithSongs(val id:Int?, val name:String, val created_at: Date, val songs: MutableList<MusicPlayerModel>)