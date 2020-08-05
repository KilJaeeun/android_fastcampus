package com.example.fastcampus.Kotlin

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(args:Array<String>){
    val a = mutableListOf<Int>(1,2,3)
    a.add(4)
    println(a) // 뒤에 삽입
    a.add(3,5)
    println(a)// 한칸씩 밀려서 들어간다.
    a.set(0,200)
    println(a)// set은 수정
    a.removeAt(1)
    println(a)// set은 수정

    println()
    val b = mutableSetOf<Int>(1,2,3)
    println(b)
    b.add(3)
    println(b)
    //b.removeAt 같이 인덱스 지정이 없고 그냥 값을 remove
    b.remove(3)
    b.remove(100)// 없는 요소 지워도 에러는 안나

    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two",2)  // key.,value 추가
    println(c)
    c.replace("two",3)  //key 안에 value 수정
    println(c)
    println(c.keys) //key 출력
    println(c.values) //value 출력
    c.clear() //딕셔너리 삭제
    println(c)





}