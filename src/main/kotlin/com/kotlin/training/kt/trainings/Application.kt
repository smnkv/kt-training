package com.kotlin.training.kt.trainings

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val kotlin = Language(name = "Kotlin", description = "Good", age = 9)
    val java = Language(name = "Java", description = "Bad", age = 25)
    val javaClone = java.copy(description = "Not so bad, but still shitty")

    println(kotlin)
    println(java)
    println(javaClone)
    println(java == javaClone) //call Language.equals
    println(java === javaClone) //call Object.equals
//    runApplication<Application>(*args)
}

interface ProgrammingLanguage {
    val name: String
    val description: String
    val age: Byte
}

data class Language(override val name: String,
                    override val age: Byte,
                    override val description: String) : ProgrammingLanguage {

    override fun toString(): String {
        return "Hello I'm $name, I'm $age years old I'm $description programming language"
    }
}