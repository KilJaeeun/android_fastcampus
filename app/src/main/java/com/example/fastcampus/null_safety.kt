package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fastcampus.Kotlin.Car

class null_safety : AppCompatActivity() {

    lateinit var lateCar: Car

    class Car(var number: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.null_safety)

        val number: Int = 10
        val number1: Int? = null
        val number5: Int = number1!! + 10
        // !! -> 개발자가 null 이 아님을 보장( 사람이 하는 것이기 때문에, 에러가 날수 있어, 사용안하길 바람)
        //
        // val number3  = number? +number1
        val number3 = number1?.plus(number)
        //   Log.d("number", "number3: " + number3)

        // 삼항 연산자 => 엘비스 연산자 (?:)// null 이면 뒤가 들어감
        // null safety를 위한 도구
        val number4 = number1 ?: 10
        // Log.d("number", "number4: " + number4)
        lateCar = Car(12)
        Log.d("number", "late number: " + lateCar.number)

    }


    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }


    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }


}
