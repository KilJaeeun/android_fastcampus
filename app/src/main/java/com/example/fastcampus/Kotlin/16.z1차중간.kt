package com.example.fastcampus.Kotlin

fun main(args: Array<String>) {
    var a1 = mutableListOf<Int>()
    for (i in 0..9) {
        a1.add(i)
    }
    var b1 = mutableListOf<Boolean>()
    for (i in a1) {
        if (i % 2 == 0) {
            b1.add(true)
        } else {
            b1.add(false)
        }

    }
    println("1번 $a1 $b1")
    fun grade(score: Int): Char {
        if ((score >= 80) && (score <= 90)) {
            return 'A'
        } else if ((score >= 70) && (score <= 79)) {
            return 'B'
        } else if ((score >= 60) && (score <= 69)) {
            return 'C'
        } else {
            return 'F'
        }
    }

    println("2번 ${grade(0)}")
    fun plusTwoTwo(first:Int, second:Int):Int{
        if((first<10) ||(second<10) ||(first>100) ||(second>100) ){
            return -1
        }
        else{
            return first+second
        }
    }

    println("3번 ${plusTwoTwo(90,78)}")
    println("4번: 구구단")
    for(mother in 1..9){
        for (son in 1..9){
            println("$mother * $son = ${mother*son}")
        }
    }

}