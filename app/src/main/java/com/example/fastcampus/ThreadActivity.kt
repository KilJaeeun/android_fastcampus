package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread is made")

            }
        }
        val thread: Thread = Thread(runnable)
        //runnable 을 thread 에 넣어줘야한다. 스레드는 트리거가 있을때 호출이 된다.


        button.setOnClickListener {
            thread.start()
        }


        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread is made2")
            }
        }).start()

        Thread(Runnable {

            Thread.sleep(2000)
            Log.d("thread-1", "Thread is made3")
            // 2초 쉬고 작동
            runOnUiThread{
                button.setBackgroundColor(getColor(R.color.colorAccent))
                //ui 를 건드는 것은 메인 스레드만 할 수 있다.   runOnUiThread!!!
            }


        }).start()



    }
}
