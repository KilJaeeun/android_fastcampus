package com.example.fastcampus.Kotlin

/*

 */

fun main(args: Array<String>) {
    val array = arrayOf<Int>(1, 2, 3)
    // get , set

    val number = array.get(0)
    println(number)
    //  val number1 = array.get(100) : 인덱스에 주의 해야한다.

    array.set(0, 100)
    val number2 = array.get(0)
    println(number2)
    //array.set(100,100)
    // array 의 바운드는 처음 만들 때 결정이 된다. 처음 만들때 사이즈 결정


    // array를 만드는 방법 3번째 (권장)
    val a1 = intArrayOf(1, 2, 3)
    //String ->"", char -> ''
    val a2 = charArrayOf('b', 'c')
    val a3 = doubleArrayOf(1.2, 100.345)
    val a4 = booleanArrayOf(true, false)


    // array를 만드는 방법 4번째 -> lamda 활용 방법
    var a5 = Array(10, { 0 })
    var a6 = Array(5, { 1;2;3;4;5 })
    var a7 = Array(6,{})

}