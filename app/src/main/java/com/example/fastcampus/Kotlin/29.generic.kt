package com.example.fastcampus.Kotlin

/*
29. generic (제너릭)
목적 다양한 타입의 객체들을 다루는 메서드나 컬렉션
클래스에서 컴파일에 타입 체크 기능
-> 타입체크 기능
 -> 제너릭은 만들기 어렵고 실제로 만들일이 거의 없기 떄문에 사용하는  방법만 숙지한다.


 */

fun main(args: Array<String>) {

    // 제너릭을 사용하지 않은 경우
    // 형 변환읗 해줘야한다.
    val list1 = listOf(1, 2, 3, "가")
    val b: String = list1[2].toString() // 형변환( 타입 변환)

    // 제너릭을 사용하는 경우
    val list2 = listOf<String>("a", "B", "c")
    val c: String = list2[2] // String 이라는 것을 보장받는다\


    // 강한 타입을 체크할 수 있다.vla
    val list3 = listOf(1, 2, 3, 4, 5, "가", "나", 2.0)
    val list4 = listOf<Int>(1, 2, 34) // 강한 타입체크


    // 제너릭을 사용하지 않는 경우
    val list5 = listOf(1, 2, 3, "가") //-> any
    // 부모 : any
    // 자식: string, int, float

}