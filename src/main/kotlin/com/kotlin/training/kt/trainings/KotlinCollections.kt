package com.kotlin.training.kt.trainings

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class KotlinCollections {
    data class Mortgage(val c: String)
    data class Loan(val content: String)
    data class Card(val cc: String)

    class AccountSummary(private val mortgage: List<Mortgage> = listOf(Mortgage("1")),
                         private val loans: List<Loan> = listOf(Loan("2")),
                         private val cards: List<Card> = listOf(Card("3"))) {

        fun toMap(): Map<String, List<*>> {
            return mapOf(
                    Pair("Mortgage", mortgage),
                    Pair("Loan", loans),
                    Pair("Cards", cards)
            )
        }
    }
}

fun main() {
    val summary = KotlinCollections.AccountSummary()
    println(summary.toMap())

    println(jacksonObjectMapper().writeValueAsString(summary.toMap()))

    summary.toMap().forEach {
        val value = it.value[0]
        if (value is KotlinCollections.Loan) {
            println("Loooooaann: ${value.content}")
        }
        if (value is KotlinCollections.Mortgage) {
            println("Mortgage: ${value.c}")
        }
    }
}