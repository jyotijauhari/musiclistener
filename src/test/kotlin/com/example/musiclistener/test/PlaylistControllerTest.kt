package com.example.musiclistener.test
import com.example.musiclistener.playlist.services.PlaylistService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

@SpringBootTest
@AutoConfigureMockMvc
class PlaylistControllerTest {

    @Autowired
    lateinit var playlistService: PlaylistService

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun initClient(context: ApplicationContext) {
        webTestClient = WebTestClient.bindToApplicationContext(context).build()
    }

    @Test
    fun whenRequestToGetPlaylistWithValidPlaylistId_thenStatusShouldBeOk() {
        val id = 2
        webTestClient.get().uri("/playlist/$id").exchange().expectStatus().isOk
    }

    @Test
    fun whenRequestToGetPlaylistWithInvalidPlaylistId_thenStatusShouldBe404PageNotFoundError() {
        val id = 9
        webTestClient.get().uri("/playlist/$id").exchange().expectStatus().is4xxClientError
    }

}


/*
* @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var playlistService: PlaylistService
    val mapper = jacksonObjectMapper()

    //    val playlist = Playlist(1, "travel", java.sql.Date(2022,9, 5))
    val song1 = MusicPlayerModel(1,"song1", "arijit singh", "hindi", Date())
    val song2 = MusicPlayerModel(3,"song2", "arijit singh", "hindi", Date())
    val song3 = MusicPlayerModel(5,"song3", "arijit singh", "hindi", Date())
    var songs = mutableListOf<MusicPlayerModel>(song1, song2, song3)
    val playlistDetails = Mono.just(PlaylistWithSongs(1, "travel", java.sql.Date(2022,9, 5), songs))


    @Test
    internal fun whenRequestToGetPlaylistWithValidPlaylistId_thenStatusShouldBeOk() {
        every { playlistService.getPlaylistDetails(1) } returns playlistDetails

        mockMvc.get("/playlist?id=1")
            .andDo { print() }
            .andExpect {
                status{isOk()}
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].name"){value("travel")}
            }
//            .andExpect{status().isOk}
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.name").value("travel"));

    }*/