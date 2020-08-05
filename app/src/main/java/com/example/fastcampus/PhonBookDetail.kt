package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phon_book_detail.*

class PhonBookDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phon_book_detail)

        getPersonInfoAndDraw()

        goback.setOnClickListener() {
    //뒤로가기 
            onBackPressed()
        }


    }


// 리스트에서 넘긴 인텐트를 받는 함수이다.

    fun getPersonInfoAndDraw() {

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }


}
