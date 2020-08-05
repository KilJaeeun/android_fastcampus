package com.example.fastcampus.Kotlin

/*
변수의 접근 범위
-------------
1. 전역 변수
2. 지역 변수
 */

var number100: Int = 10
fun main(args: Array<String>) {
    println(number100)

    val test = Test()
    test.testFun()
    println(number100)
}

class Test(var name: String = "홍길동") {


    fun testFun() {
        var birth: String = "1999/01/01"
        name = "홍길동"
        number100 = 100





    }

    fun testFunc2() {

    }

}