package com.example.fastcampus.Kotlin

// 16.Iterable

fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)


    //반복하는 방법(1)
    for (item in a) {
        println(item)
    }
    println()
    //반복하는 방법(2)
    for ((idx, item) in a.withIndex()) {
        println("idx: $idx , item: $item")
        //문자열  + 정수  = 문자열
        //문자열 + 아무거나 = 문자열
    }
    println()

    //반복하는 방법(3)
    a.forEach({
        println(it)
    })

    println()
    //반복하는 방법(4) 중요
    a.forEach { item ->
        println(item)
    }
    println()
    //반복하는 방법(5) 중요
    a.forEachIndexed { idx, item -> println("idx: $idx , item: $item") }


    println()
    //반복하는 방법(6)
    println(a.size)
    for (i in 0 until a.size) {
        // 0 부터 asize 미만까지
        // until 은 마지막을 포함하지 않는다.
        println(a.get(i))
    }
    println()
    //반복하는 방법(7)

    for (i in 0 until a.size step (2)) {
        //0 2 4 6 8
        println(a.get(i))
    }
    println()
    //반복하는 방법(8)
    for (i in a.size - 1 downTo (0)) {
        // 8부터 0 까지 반복
        println(a.get(i))
    }
    println()
    //반복하는 방법(9)
    for (i in a.size - 1 downTo (2) step (2)) {
        // 8부터 0 까지  2 뛰어서 반복
        println(a.get(i))
    }
    println()
    //반복하는 방법(10)
    for (i in 0..a.size) {
        //.. 는 마지막을 포함한다.
        println(i)
    }
    println()
    //반복하는 방법(11) : while 문
    var b: Int = 0 //->1
    var c: Int = 4
    while (b < c) {
        b++  //while 문을 정지시키기 위한 코드
        println(b)
    }
    println()
    //반복하는 방법(12) : do while 문
    // 조건에 안맞아도 한번은 돌게 보장한다.
    do {
        println("hello")
    } while (b < c)
}
