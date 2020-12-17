package com.kotlin.training.kt.trainings

class UsefulTricksForCollections {
}

interface Card {
    val accountNumber: String
    val customerName: String

    fun print() = println(this).let { this }
}

data class DefaultCard(override val customerName: String = "Name",
                       override val accountNumber: String = "12345678") : Card

data class MaskedCard private constructor(override val accountNumber: String,
                                          override val customerName: String) : Card {
    constructor(defaultCard: Card) : this(mask(defaultCard.accountNumber), defaultCard.customerName)

    companion object {
        fun mask(accountNumber: String): String {
            return with(accountNumber) {
                "${"*".repeat(length - 4)}${slice(length - 4 until length)}"
            }
        }
    }
}

fun main() {
    val notMasked = DefaultCard().print()

    val maskedCardNumber = MaskedCard(defaultCard = notMasked).print()
}