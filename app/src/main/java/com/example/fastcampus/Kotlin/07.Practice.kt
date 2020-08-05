package com.example.fastcampus.Kotlin

fun main(array: Array<String>) {

    // 산술 연산자
    // ctrl shift f10 은 run 단축키
    var a = 10 + 11
    var b = 10 - 1
    var c = 1 * 9
    var d = 20 / 3
    var e = 20 % 3
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    // 대입 연산자
    val f = 5
    // 복합 대입 연산자
    a += 29
    b -= 10
    c *= 3
    d %= 4
    e /= 4
    println()
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    // 증감 연산자

    a++
    b--
    println()
    println(a)
    println(b)

    //비교 연산자
    var g = a > b
    var h = a == b
    var i = !h
    var l = i != h
    println()
    println(g)
    println(h)
    println(i)
    println(l)


    // 논리 연산자
    val j = h && i
    val k = h || i

    println()
    println(j)
    println(k)

}