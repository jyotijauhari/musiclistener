package com.example.musiclistener.playlist.services
import com.example.musiclistener.playlist.controller.WebClientAPI
import com.example.musiclistener.playlist.model.*
import com.example.musiclistener.playlist.repository.PlaylistRepository
import com.example.musiclistener.playlist_songs.model.NotFoundException
import com.example.musiclistener.playlist_songs.services.PlaylistSongsService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlaylistService(
    val playlistRepository: PlaylistRepository,
    val playlistSongsService: PlaylistSongsService
) {
     fun getAllPlaylist(): Flux<Playlist> {
        return playlistRepository.findAll()
    }


    fun getPlaylistDetails(playlistId: Int): Mono<PlaylistWithSongs> {
        val songIds = playlistSongsService.getSongsId(playlistId)
        val api = WebClientAPI()
        val playlist = getPlaylistById(playlistId)
        val allSongs = songIds.flatMap { id -> api.getSongById(id) }
        val allSongsList = songIds.flatMap { id -> api.getSongById(id) }.collectList()

        return playlist.zipWith(allSongsList) { t1, t2 -> PlaylistWithSongs(t1.id, t1.name, t1.created_at, t2) }
    }

    fun getPlaylistById(playlistId: Int): Mono<Playlist> {
        return playlistRepository
            .findById(playlistId)
            .switchIfEmpty(Mono.error(
                NotFoundException("Playlist with playlist id : $playlistId not found")
            ))
    }

    fun deleteSongFromPlaylist(playlistId: Int, songId: Int): Mono<Void> {
        return getPlaylistById(playlistId)
            .flatMap { playlistSongsService.deleteSongFromPlaylist(playlistId, songId) }
    }

}