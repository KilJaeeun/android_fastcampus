package com.example.fastcampus.Kotlin

/*

04. Function
- 함수
   - 어떤 input 을 넣어주면, 어떤 output 이 나오는 것
   - y =x+2


 - 함수를 선언하는 방법

  fun 함수먕 ( 변수명  : 타입, 변수명: 타입, ...): 반환형 {
  //함수 내용
  return 반환값
  }

 */
fun plus(first: Int, second: Int): Int {
    val result: Int = first + second
    return result
}

// 디폴트를 가지는 함수 만들기
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

// 반환값이 없는 함수 만들기
fun printPlus(first: Int, second: Int): Unit { //unit: return nothing 
    //unit 생략 가능
    val result: Int = first + second
    println(result)
}

// 간단하게 함수를 선언하는 방법
fun plusShort(first: Int, second: Int) = first + second

// 가변인자를 가지는 함수를 선언하기
fun plusMany(vararg  numbers:Int){
    for (number in numbers){
        println(number)
    }
}
fun main(array: Array<String>) {
    val result = plus(66, 5)
    val result2 = plus(first = 26, second = 1) //인수 명시 가능
    val result3 = plus(second = 6, first = 1) //자리 교환 가능
    println(result)
    println(result2)
    println(result3)


    //디폴트 값을 가지는 함수 호출하기
    println()
    val result4 = plusFive(10, 20)
    println(result4)
    val result5 = plusFive(10)
    println(result5)
    printPlus(100, 100)
    val result6 = plusShort(0, 1)
    println(result6)
    plusMany(1,2,3,4,5,6,7,8,9)
}