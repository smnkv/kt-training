package com.kotlin.training.kt.trainings

class KotlinExpressions {

}

val printMyName = { name: String -> println(name) }

typealias FunctionReturningString = () -> String

val printMyNameFromExternalSource = { getMyName: FunctionReturningString -> printMyName(getMyName()) } //higher order function

fun main() {
    printMyName("This is My Name")

    printMyNameFromExternalSource { "This is my name from external source, cool?" }
}