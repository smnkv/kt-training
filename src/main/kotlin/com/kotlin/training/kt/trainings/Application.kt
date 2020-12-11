package com.kotlin.training.kt.trainings

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val kotlin = Language(name = "Kotlin", description = "Good", age = 9)
    val java = Language(name = "Java", description = "Bad", age = 25)
    val java15 = VersionedLanguage(language = java.copy(description = "Not so bad, but still shitty"), version = 15)

    println(kotlin)
    println(java)
    println(java15)

    println(java15.toJson())
    println(java.toJson())
    println(kotlin.toJson())

    println(java.toJson().fromJson<NotImplementing>())
    println(java.toJson().fromJson<Language>())
    println(java15.toJson().fromJson<VersionedLanguage>())

    val java15FromJson: VersionedLanguage = java15.toJson().fromJson() //roots of VersionedLanguage type
//    runApplication<Application>(*args)
}

fun ProgrammingLanguage.toJson(): String {
    return jacksonObjectMapper().writeValueAsString(this)
}

inline fun <reified T> String.fromJson(): T { //reified == materialised
    return jacksonObjectMapper().readValue(this)
}

interface ProgrammingLanguage {
    val name: String
    val description: String
    val age: Byte
}

data class VersionedLanguage(val version: Long,
                             @JsonIgnore val language: Language) : ProgrammingLanguage by language {
    @JsonCreator
    constructor(version: Long, name: String, description: String, age: Byte)
            : this(version = version, language = Language(name, age, description))

    override fun toString(): String {
        return "$language, version: $version"
    }
}

data class NotImplementing(val name: String?, val age: Byte?, val description: String?)

data class Language(override val name: String,
                    override val age: Byte,
                    override val description: String) : ProgrammingLanguage {

    override fun toString(): String {
        return "Hello I'm $name, I'm $age years old I'm $description programming language"
    }
}