package com.example.fastcampus
// MainActivity.kt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.l15final)
        // 화면을 그려주는 함수 : setContentView
        // 생성할 떄 1번 화면을 그려준다.
        //R.layout.activity_main  : activity_main.xml 이 내가 에뮬레이터에 올리는 파일

        Log.d("life_cicle", "onCreate")

    }

    // log 를 println 대신 사용( 이게 더 좋음)
    override fun onStart() {
        super.onStart()
        Log.d("life_cicle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cicle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cicle", "onPause")
    }


    override fun onStop() {
        super.onStop()
        Log.d("life_cicle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cicle", "onDestroy")
    }

}
