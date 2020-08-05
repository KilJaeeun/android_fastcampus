package com.example.fastcampus.Kotlin

fun main(args: Array<String>) {
    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }
    if (b + c == 110) {
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }


    // 엘비스 연산자.( 자주 활용할 수록 좋다. 널 대응 많이 해주는 것)
    val number: Int? = null
    val number2 = number ?: 10 //number 가 null 인경우 10 이 들어감. (null safety)
    println()
    println(number2)

    val num1: Int = 10
    val num2: Int = 20
    // else 꼭 만들어라.
    var max = if (num1 > num2) {
        num1
    } else if (num1 == num2) {
        num2
    }else{
        100
    }
    println()
    println(max)
}