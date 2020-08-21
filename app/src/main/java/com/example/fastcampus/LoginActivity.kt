package com.example.fastcampus

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 로그인 상태의 경우
        if ((application as MasterApplication).checkIsLogin()) {
            finish() //activity 종료
            startActivity(
                Intent(this@LoginActivity, OutStagramPostListActivity::class.java)
            )
        } else {
            setContentView(R.layout.activity_login)
            // 양 적어서 initView  안만듦


            register.setOnClickListener {
                val intent =
                    Intent(this, EmailSignupActivity::class.java) // 회원가입하기 누르면 , 회원가입 창으로 보내기
                startActivity(intent)
            }
            login.setOnClickListener {
                // 재료 준비 시작
                val username = username_inputbox.text.toString()
                val password = password_inputbox.text.toString()
                // 재료 준비 끝
                // 통신 시작
                (application as MasterApplication).service.login(
                    username, password
                ).enqueue(object : retrofit2.Callback<User> {
                    override fun onFailure(call: Call<User>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if (response.isSuccessful()) {
                            val user = response.body()
                            val token = user!!.token!!
                            saveUserToken(token, this@LoginActivity)
                            // 헤더를 만들기 위해서 retrofit 돌려줘야함.
                            (application as MasterApplication).createRetrofit()
                            Toast.makeText(this@LoginActivity, "로그인 했어요", Toast.LENGTH_LONG).show()
                            startActivity(
                                Intent(this@LoginActivity, OutStagramPostListActivity::class.java)
                            )
                        }
                    }
                })

            }

            // 통신 끝
        }

    }

    // token 저장 시작
    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }
    // token 저장 끝


}