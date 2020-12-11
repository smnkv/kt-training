package com.kotlin.training.kt.trainings

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val kotlin = Language("Kotlin", "Good", 9)
    val java = Language("Java", "Bad", 25)
    val javaClone = Language("Java", "Bad", 25)

    println(kotlin)
    println(java)
    println(java == javaClone) //call Language.equals
    println(java === javaClone) //call Object.equals
//    runApplication<Application>(*args)
}


data class Language(private val name: String,
                    private val description: String,
                    private val age: Byte) {

    override fun toString(): String {
        return "Hello I'm $name, I'm $age years old I'm $description programming language"
    }
}