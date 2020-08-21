package com.example.fastcampus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_outstagram_user_info.*

class OutStagramUserInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_user_info)


        all_list.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramPostListActivity::class.java
                )
            )
        }
        my_list.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramMyPostListActivity::class.java
                )
            )
        }
        upload.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramUploadActivity::class.java
                )
            )
        }

        
        // 로그아웃
        logout.setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp", "null")  //로그아웃
            editor.commit()
            (application as MasterApplication).createRetrofit()
            finish() // 화면 종료
            startActivity(Intent(this, LoginActivity::class.java)) // 로그인 화면으로 보내기
        }
    }
}