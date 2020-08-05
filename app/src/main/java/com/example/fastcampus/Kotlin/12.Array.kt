package com.example.fastcampus.Kotlin


/*
12. 배열

** 배열이 필요한 이유
- 그룹, 모음집이 필요할 때

 */

fun main(array: Array<String>) {
    val one: Int = 1
    val two: Int = 1
    val three: Int = 1
    val four: Int = 1

    /// 배열을 생성하는 방법(1)
    val group1 = arrayOf<Int>(1, 2, 3, 4, 5, 6, 88, 22)

    println(group1 is Array)
    /// 배열을 생성하는 방법(2)
    val group2 = arrayOf(1, true, 3.13, 4, 5, "6", 88, 22)

    // 배열의 값을 꺼내는 방법(1)

    //index 란?
    //=> 순서(번째)
    // [1,2,3,4,5]
    // "0"부터 시작
    //index 0 ->1 , index 1->2
    // 배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    val test2 = group1.get(4)
    println(test1)
    println(test2)
    // 배열의 값을 꺼내는 방법(2)
    val test3 = group1[0]
    val test4 = group1[4]
    println(test3)
    println(test4)

    // 배열의 값을 바꾸는 방법(1)
    group1.set(0, 100)
    println(group1[0])
    // 배열의 값을 바꾸는 방법(2)
    group1[0]=200
    println(group1[0])
}