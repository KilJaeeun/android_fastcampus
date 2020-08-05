package com.example.fastcampus

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.intent_second.*

class intent_second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_second)

        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number", 0)
            Log.d("number", number1.toString())
            Log.d("number", number2.toString())


            val result = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            setResult(Activity.RESULT_OK, resultIntent)
            // 응답코드랑 보내야 하는 내용물은 putExtra 를 이용해 Intent 에 삽입하고 보내준다.
            finish() // activity 종료

            // 앱은 stack 의 개념으로 올라가기 떄문에  intent second가 종료되면, intent first 가 나온다.
            
        }


    }
}
