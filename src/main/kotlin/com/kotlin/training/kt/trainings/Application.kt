package com.kotlin.training.kt.trainings

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val kotlin = Language("Kotlin", "Good", 9)
    val java = Language("Java", "Bad", 25)

    println(kotlin)
    println(java)
//    runApplication<Application>(*args)
}


class Language(private val name: String,
               private val description: String,
               private val age: Byte) {

    override fun toString(): String {
        return "Hello I'm $name, I'm $age years old I'm $description programming language"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Language

        if (name != other.name) return false
        if (description != other.description) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + age
        return result
    }
}