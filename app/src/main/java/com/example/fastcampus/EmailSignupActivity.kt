package com.example.fastcampus

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_email_signup.*
import kotlinx.android.synthetic.main.fragment_one.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignupActivity : AppCompatActivity() {

    lateinit var userNameView: EditText
    lateinit var userPassword1View: EditText
    lateinit var userPassword2View: EditText
    lateinit var registerBtn: TextView
    lateinit var loginBtn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 로그인 상태의 경우
        if ((application as MasterApplication).checkIsLogin()) {
            finish() //activity 종료
            startActivity(
                Intent(this@EmailSignupActivity, OutStagramPostListActivity::class.java)
            )
        } else {
            if ((application as MasterApplication).checkIsLogin()) {
                finish()
                //  startActivity(Intent(this, ))
            } else {
                setContentView(R.layout.activity_email_signup)
                initView(this@EmailSignupActivity) //init 뒤에 register 순서 유의
                setupListener(this)

            }

        }


    }


    fun setupListener(activity: Activity) {

        register.setOnClickListener {
            register(this@EmailSignupActivity)
            // 로그인 버튼 누르면 로그인 화면으로 전환

            loginBtn.setOnClickListener {
                startActivity(
                    Intent(this@EmailSignupActivity, LoginActivity::class.java)
                )
            }
        }

    }

    fun register(activity: Activity) {

        // 가입 절차 진행
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2 = getUserPassword2()
        val register = Register(username, password1, password2)

        (application as MasterApplication).service.register(
            // step1: 객체를 보내줄 경우
            //register
            //step2: 필드를 보내줄 경우
            username,
            password1,
            password2

        ).enqueue(object :
            Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "가입에 실패하였습니다. ", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(activity, "가입에 성공하였습니다. ", Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)
                    // 이제 로그인할 수 있는 토큰값이 생김.
                    (application as MasterApplication).createRetrofit()
                    activity.startActivity(
                        Intent(activity, OutStagramPostListActivity::class.java)
                    )
                }


            }
        })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

    fun initView(activity: Activity) {

        userNameView = activity.findViewById(R.id.username_inputbox)
        userPassword2View = activity.findViewById(R.id.password1_inputbox)
        userPassword1View = activity.findViewById(R.id.password2_inputbox)
        loginBtn = activity.findViewById(R.id.login)
    }

    fun getUserName(): String {
        return userNameView.text.toString()
    }

    fun getUserPassword1(): String {
        return userPassword1View.text.toString()
    }

    fun getUserPassword2(): String {
        return userPassword2View.text.toString()
    }


}