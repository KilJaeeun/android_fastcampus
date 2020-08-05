package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 프래그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
        /*
        inflater => 뷰를 그려주는 역할
        container => 부모뷰
        savedInstanceState =>
         */
        Log.d("life_cicle", "Frag o onCreateView")
        return inflater.inflate(R.layout.fragment_two, container, false)

        //return super.onCreateView(inflater, container, savedInstanceState)
    }
}
