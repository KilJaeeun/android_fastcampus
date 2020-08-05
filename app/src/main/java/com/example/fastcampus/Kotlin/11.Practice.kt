package com.example.fastcampus.Kotlin

/*
11. 제어흐름 실습
 */

fun main(args: Array<String>) {
    val value: Int? = null
    when (value) {
        null -> println("value is null")
        else -> println("value is not null")
    }
    val value2: Boolean? = null
    when (value2) {
        true -> println("value is true")
        false -> println("value is false")
        null -> println("value is null")  // 반드시 when 구문 모든 경우를 포괄해야함
    }
    // 값을 return 하는 when 구문의 경우, 반드시 값을 리턴해야한다.
    val value3 = when (value2) {
        true -> 1
        false -> 3
        else -> 4
    }
    println()
    println(value3)
//when 의 다양한 조건식(1)
    val value4: Int = 10
    when (value4) {
        is Int -> {
            //is : 타입확인
            println("value4 is Int")
        }
        else -> {
        println("value4 is not Int")
    }
    }
    //when 의 다양한 조건식(2)
    val value5: Int = 87
    when (value5) {
        in 50..70 -> {
            // 50과 90 사이에 있다.
            println("value5 is in 50..70")
        }
        in 70..80-> println("value5 is in 70..80")
        else -> {
            println("value5 is not  in 50..80")
        }
    }
}