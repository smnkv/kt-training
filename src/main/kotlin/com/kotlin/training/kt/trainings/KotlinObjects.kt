package com.kotlin.training.kt.trainings

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class KotlinObjects


object SingletonObject {
    var name = "Singleton"
        set(value) {
            synchronized(this) {
                println("Hello from synchronized setter")
                field = value
            }
        }

    fun printName() = println(name)

    fun getNewObject() = object { //could implement interfaces/abstract classes as normal class
        val newName = name //could be used as DTO's
    }
}

fun main() {
    SingletonObject.printName()

    jacksonObjectMapper().writeValueAsString(SingletonObject.getNewObject()).also { println(it) }

    SingletonObject.name = "NewNameForSingleton"

    SingletonObject.printName()

    jacksonObjectMapper().writeValueAsString(SingletonObject.getNewObject()).also { println(it) }
}