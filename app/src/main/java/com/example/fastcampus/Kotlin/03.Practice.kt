package com.example.fastcampus.Kotlin

var a = 1 + 2 + 3 + 4 + 5 //연산의 결과값을 변수에 넣어줄 수 있다.
var b = "10"
var c = b.toInt()// int 로 바꾸겠다.
var d = b.toFloat() //float 로 바꾸겠다.

var e = "John"
var f = "My name is $e Nice to meet you"  //문자열 중간 변수의 삽입

/*
null : 존재하지 않는다.


 */


//var abc: Int = null
var abc: Int? = null // 자료형 뒤에 ? 를 붙이면, null 포함 가능 자료형이다.

var g = a+3


fun main(array: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(abc)
    println(g)
}