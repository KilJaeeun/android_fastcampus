package com.example.fastcampus.Kotlin

fun first() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })

    for (i in 0..8) {
        list1[i] = i + 1


    }

    println(list1)
    list1.forEachIndexed { index, value ->
        if (value % 2 == 0) {
            list2[index] = true
        } else {
            list2[index] = false
        }
    }
    println(list2)

}

fun second(score:Int):String{
    when(score){
        in 90..100-> return "A "
        in 80..89-> return "B"
        in 70..79-> return "C "
        else-> return "F "
    }
}

fun third(number: Int):Int{
    val a:Int = number /10
    val b:Int = number %10
    return a+b
}


fun gugudan(){
    for(mother in 1..9){
        for (son in 1..9){
            println("$mother * $son = ${mother*son}")
        }
    }
}