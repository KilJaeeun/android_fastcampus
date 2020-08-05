package com.example.fastcampus

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {
    interface OnDataPassListener {
        fun onDataPass(data: String?)
    }

    lateinit var dataPassListener: OnDataPassListener
    override fun onAttach(context: Context) {
        Log.d("life_cicle", "Frag onAttach")
        super.onAttach(context)
        // "Asdwe" as Int

        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cicle", "Frag onCreate")
        super.onCreate(savedInstanceState)
    }

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
        return inflater.inflate(R.layout.fragment_one, container, false)

        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cicle", "Frag onViewCreated")
        val data = arguments?.getString("hello")
        Log.d("data", data)

        super.onViewCreated(view, savedInstanceState)
// activity 의 oncreate 에서 했던 작업을 여기에서 한다.
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cicle", "Frag onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cicle", "Frag onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cicle", "Frag onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cicle", "Frag onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cicle", "Frag onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cicle", "Frag onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cicle", "Frag onDetach")
        super.onDetach()
    }
}