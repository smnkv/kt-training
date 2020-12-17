package com.kotlin.training.kt.trainings

class BooleanYesNo {
}

fun Boolean.asString(): String {
    return if (this) "Yes" else "No"
}

fun main() {
    println(true.asString())
    println(false.asString())
    println(true)
    println(false)
}