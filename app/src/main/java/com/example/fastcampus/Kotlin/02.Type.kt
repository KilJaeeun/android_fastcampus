package com.example.fastcampus.Kotlin

/*
02. 자료형
정수형 => Long > Int > Short > Byte
실수형 => Double > Float
문자형 => Char
문자열 => String
논리형(참 True, 거짓 False) => Boolean
 */

/*
변수 선언 방법 (1)
variable, value 변수명 =값
var/val 변수명  = 값
--
var number =10
 number = 20
  //number =20.5
 */
var number =10
/*
변수 선언 방법 (2)
variable, value 변수명 : 자료형 =값
자료형 안 지정해주면 초기 값으로 자료형을 스스로 판단해서 결정한다.

 */

var number1:Int =20
var hello1:String = "Hello"
var pointer1:Double = 3.4

/*
variable or value?
=> 1. 변하지 않는 값이라면:value
2. 변할지 아닐지 모름 :value ( 나중에 var 로 바꿈)
3. 변한다: variable

 */


fun main(array: Array<String>){
    number =20
}