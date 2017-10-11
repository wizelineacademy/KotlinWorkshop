package com.wizeline.workshop

fun main(args: Array<String>) {
    println("How much dollars do you want to convert?")
    val input = readLine()
    println("Please wait meanwhile I convert it")
    try {
        val model = DollarBitcoinConverter().execute(input)
        println("${model.dollar} dollars is equal to ${model.bitcoin}")
    } catch (e: Exception) {
        println("Error ${e.message}")
    }
}
