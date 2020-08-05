package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listenr.*

class Listener : AppCompatActivity() {

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listenr)

/*
 뷰를 activity로 가져오는 방법
 1> 직접 찾아서 가져온다.
 val textView : TextView = findViewById(R.id.hello)
2> xml 을 import 해서 가져온다.
import kotlinx.android.synthetic.main.activity_listenr.*
hello.
 */

        // 익명함수
        // 1=> 람다 방식
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 위에와 동일하게 작동하는 본 함수
        // 2=> 익명함수 방식
        /*  hello.setOnClickListener(object: View.OnClickListener{
              override fun onClick(v: View?) {
                  Log.d("click", "Click!!")
              }
          })
          */
        //3=> 이름이 필요한 경우(click)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
                //hello.setText("안녕하세여")
                //    image.setImageResource(R.drawable.cat)
                number += 10
                Log.d("number", "" + number)
            }
        }

        hello.setOnClickListener(click)







        }


        // 뷰를 조작하는 함수들


    }


