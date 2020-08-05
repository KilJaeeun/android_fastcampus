package com.example.fastcampus.Kotlin

/*
08. 제어 흐름
- if /else



 */
fun main(array: Array<String>) {


    val a: Int = 5
    val b: Int = 10

    // if / else 사용 법 (1)=> else 꼭 있을 필요는 없다.
    println("조건 시작")
    if (a > b) {
        println(" a 가 b 보다 크다")
    } else if (a == b) {
        println("a 와 b 는 같다.")
    } else {
        println("a 가 b 보다 작다")
    }
    println("조건 끝")

    // 값을 리턴하는 if 사용 방법
    var max = if (a > b) {
        a
    } else {
        b
    }
    // 값을 리턴하는 if 사용 방법 (2)

    max = if (a > b) a else b

    println()
    println(max)
// 자바는 안되지만, 코틀린의 경우 중괄호  내용물 한줄일 때, 생략 가능합니다.
}