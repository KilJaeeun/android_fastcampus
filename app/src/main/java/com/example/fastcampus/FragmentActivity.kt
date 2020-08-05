package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {
    override fun onDataPass(data: String?) {
        Log.d("pass", ""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentOne: FragmentOne = FragmentOne() // 전역변수와 지역변수
        // 프라그먼트에 data 를 넣어주는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        button_id.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법''ㅍ미f
            //프라그먼트 붙이는 방법 : replace, add
            val fragmentManager: FragmentManager = supportFragmentManager
            // Transaction
            // 작업 단위 -> 시작과 끝이 있다.
            val fragmentTracesaction = fragmentManager.beginTransaction()
            fragmentTracesaction.replace(R.id.container, fragmentOne)
            fragmentTracesaction.commit()
            // 끝을 내는 방법
            //commit -> 시간 될 떄 해 (좀 더 안정적)
            // commit now -> 지금당장해
        }
        button2_id.setOnClickListener {
            //  val fragmentOne:FragmentOne = FragmentOne()

            //프라그먼트 remove, detach 하는 방법
            //remove -> 다시 붙일수 있고, detach는 다시 붙일 수 없다.
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
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
