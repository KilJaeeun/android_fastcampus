package com.example.fastcampus.Kotlin

/*
14. Collection
-> list , set, map
값을 변경 가능한 collection 과 값 변경 불가능인 collection
Immutable Collections( 변경 불가능)
Mutable Collections( 변경 가능)


 */

fun main(args: Array<String>) {

    /*
    Immutable Collections( 변경 불가능)
     */
    //List -> 중복 허용함
    val numberList = listOf<Int>(1, 2, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])
    //Set:집합 -> 중복 허용 안함 -> 순서, 인덱스가 없다.
    val numberSet = setOf<Int>(1, 2, 3, 4, 4, 3, 2)
    println()
    println(numberSet)
    numberSet.forEach {

        println(it)
    }


    //Map -> key, value 방식으로 관리한다.
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap.get("one"))
    //get 함수 내부에 이것을 찾는다.

    /*
    Mutable Collections( 변경 가능) : set, add 사용 가능
     */

    val mNumberList = mutableListOf<Int>(1, 2, 3)
    println()
    println(mNumberList)
    mNumberList.add(3, 77)
    println(mNumberList)
    println()


    val mNumberSet = mutableSetOf<Int>(3, 5, 6, 23, 1, 3, 5)
    //mNumberSet.add(4,10)
    println(mNumberSet)
    mNumberSet.add(10)
    //set 은 인덱스가 없어서 add 만 한다,
    println(mNumberSet)
    println()


    val mNumberMap = mutableMapOf<String, Int>("one" to 1, "two" to 2)
    println(mNumberMap)
    // map 은 put 이라는 것으로 요소를 삽입한다.
    mNumberMap.put("three",3)
    println(mNumberMap)

}