package com.kotlin.training.kt.trainings

import java.io.File


class FilesInKotlin


fun main() {
    val path = "src/main/kotlin/com/kotlin/training/kt/trainings/File.txt"

    File(path).forEachLine { println(it) }
    println()
    File(path).readText().let { println(it) }
}