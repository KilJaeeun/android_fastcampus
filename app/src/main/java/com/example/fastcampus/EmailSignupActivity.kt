package com.example.fastcampus

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if ((application as MasterApplication).checkIsLogin()) {
            finish()
            //  startActivity(Intent(this, ))
        } else {
            setContentView(R.layout.activity_email_signup)
            initView(this@EmailSignupActivity)
            setupListener()

        }

    }


    fun setupListener() {

        register.setOnClickListener {
            register(this@EmailSignupActivity)
        }

    }

    fun register(activity: Activity) {
        val username = userNameView.text.toString()
        val password1 = userPassword1View.text.toString()
        val password2 = userPassword2View.text.toString()
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
