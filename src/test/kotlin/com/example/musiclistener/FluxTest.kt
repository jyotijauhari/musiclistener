package com.example.musiclistener

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import java.time.Duration

class FluxTest {
    @Test
     fun fluxTest() {
        Flux.just(1,2,3)
            .log()
            .subscribe { data -> println(data) }
    }

    @Test
     fun fluxWithError() {
        Flux.just(1,2,3)
//            .concatWith(Flux.error(RuntimeException("some error")))
            .log()
            .subscribe ({ data -> println(data) },
                { error-> println("errror is $error")},
                { println("completed") })
    }

    @Test
    fun fluxWithIterables() {
        Flux.fromIterable(listOf("A","B","C"))
            .log()
            .subscribe({data-> println(data) })
    }

    @Test
    fun fluxWithInterval() {
        Flux.interval(Duration.ofSeconds(1))
            .log()
            .subscribe({data-> println(data) })

        Thread.sleep(5000)
    }
}