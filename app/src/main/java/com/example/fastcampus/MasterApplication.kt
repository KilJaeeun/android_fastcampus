package com.example.fastcampus

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 모든 액티브티에서 사용가능한 클래스 구현 방법
class MasterApplication : Application() {
    lateinit var service: RetrofitService


    //activity 가 application 보다 상위에 있기 때문에, oncreate 함수는 이게 제일 먼저 구동된다.
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this) //stetho init
        createRetrofit()
        //chrome://inspect/#devices ( 크롬 개발자도구를 활용해서 네트워크  통신을 눈으로 직접 볼 수 있다.)
    }


    fun createRetrofit() {
        // Interceptor: 나가려는 통신을 가로채서( 헤더 붙이는 개조를 수행한 후) 수정해 내보냄.
        val header = Interceptor {
            val original = it.request()


            if (checkIsLogin()) {

                getUserToken()?.let { token ->
                    val request =
                        original.newBuilder().header("Authorization", "token " + token).build()
                    it.proceed(request)
                }


            } else {
                it.proceed(original)
            }
        }
        val client =
            OkHttpClient.Builder().addInterceptor(header).addInterceptor(StethoInterceptor())
                .build()
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()


        service = retrofit.create(RetrofitService::class.java)
    }

    // 인증 토큰 값이 있으면 => 로그인 상태
    // 없으면 로그인 안되어있는  상태로 간주하기

    fun checkIsLogin(): Boolean {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return true
        else return false
    }

    // 로그인이 되었는지 확인
    fun getUserToken(): String? {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return null
        else return token
    }

}