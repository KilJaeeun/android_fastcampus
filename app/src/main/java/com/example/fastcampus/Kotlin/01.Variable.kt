package com.example.fastcampus.Kotlin

/*
01. Variable => 변수

=> 변수는 상자
변수는 상자다. 상자 내용물이 필요하면 상자를 가져와 꺼내면 된다.
상자에 집어 넣는 물건이 엄청 복잡한 과정을 거쳐 나온 결과값이면, 우리가 맨날맨날
연산할 필요 없이 한번 계산하고 상자를 가져와 쓴다.


=> 변수  선언하는 방법
var/val 변수명(상자) = 값 ( 넣고 싶은 것)
vaiable , value
( 내 마음대로 원하는 것을 넣을 수 있는 상자[let],  한 번 넣으면 바꿀 수 없는 상자[const])
 var num =10
 var hello ="hello"
 var point =3.4
 val fix = 20
 */
var num = 10
var hello = "hello"
var point = 3.4
val fix = 20

// main function
fun main(args: Array<String>) {
    //print func : println
    println(num)
    println(hello)
    println(point)
    println(fix)
    num=100
    hello="good bye"
    point =1.4
    println(num)
    println(hello)
    println(point)

    //fix =500

}