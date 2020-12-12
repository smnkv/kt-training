package com.kotlin.training.kt.trainings

import com.kotlin.training.kt.trainings.Serial.UmbrellaAcademy
import com.kotlin.training.kt.trainings.Serial.Warrior
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import reactor.kotlin.core.util.function.component1
import reactor.kotlin.core.util.function.component2

interface Serial {
    val name: String
    fun watch() {
        println("Watching $name")
    }

    data class Warrior(override val name: String = "Warrior") : Serial
    data class UmbrellaAcademy(override val name: String = "UmbrellaAcademy") : Serial
}

interface Sources {
    fun loadFromPirateBay(): Mono<Serial>
    fun watchOnNetflix(): Mono<Serial> = throw RuntimeException("No subscription available.")
    fun reachOutToFriedWithNetflixSubscription(): Mono<Serial>

    class MySources : Sources {
        override fun loadFromPirateBay(): Mono<Serial> {
            return Warrior().toMono()
        }

        override fun reachOutToFriedWithNetflixSubscription(): Mono<Serial> {
            return UmbrellaAcademy().toMono()
        }
    }
}

fun main() {
    val mySources = Sources.MySources()

    Mono.zip(
            mySources.loadFromPirateBay(),
            mySources.reachOutToFriedWithNetflixSubscription()
    ).map { (warrior, umbrella) ->
        warrior.watch()
        umbrella.watch()
    }.subscribe()

    println("Hello form new main!")

}