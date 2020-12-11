package com.kotlin.training.kt.trainings

class ObjectDeconstruction {

}

val java = VersionedLanguage(version = 15, name = "Java", description = "Old language with tons of boiler-plate", age = 25)
val kotlin = VersionedLanguage(version = 1.41.toLong(), name = "Kotlin", description = "Language witch help to solve issues", age = 9)

fun main() {
    println("Hello form new main!")
    listOf(java, kotlin)
            .forEach { (version, language) ->
                val (name, age, description) = language
                print("""
                    Version	Age     Name
                    $version   $age    $name
                """).also { println() }
            }
}