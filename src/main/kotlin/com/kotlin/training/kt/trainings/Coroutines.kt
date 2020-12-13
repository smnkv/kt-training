package com.kotlin.training.kt.trainings

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Coroutines {
    suspend fun generatePdf(i: Int, d: Long = 5000) {
        delay(d)
        println("$i Pdf generated!")
    }
}

fun main(args: Array<String>) {
    val generator = Coroutines()

    for (i in 0..100) {
        GlobalScope.launch {
            generator.generatePdf(i)
        }
    }

    runApplication<Coroutines>(*args)
}