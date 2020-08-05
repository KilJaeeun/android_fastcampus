package com.example.fastcampus

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class resource : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        // 0번
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment: " + ment)
        // 1번
        val ment2 = getString(R.string.hello)
        Log.d("mentt", "ment: " + ment2)


        val color = getColor(R.color.textview_color)
        Log.d("mentt", "color: " + color)

        // 버전이 맞지 않은 경우 : SDK 버전에 따른 분기 처리
        val color2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getColor(R.color.textview_color)
        } else {
            resources.getColor(R.color.textview_color)
        }


        button.setBackgroundColor(getColor(R.color.textview_color))
        Log.d("mentt", "color: " + color2)

    }
}
