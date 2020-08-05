package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        //"http://mellowcode.org/json/students/"
        // "http://mellowcode.org/test/students/"
        // "http://mellowcode.org/code/students/"
        //baseUrl : 변하지 않는 부분

        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        //retrofit 관리 서비스 만들기
        val service = retrofit.create(RetrofitService::class.java)

        // enqueue: (이 통신을 네트워크라는 큐 위에 올린다.)
        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "fail")
                call.isCanceled()
                call.isExecuted()
                call.cancel() // retry 통신을 막는다.
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res age:  " + personList?.get(0)?.age)
                    val code = response.code()
                    Log.d("retrofitt", "res code:  " + code)
                    val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "res header:  " + header)
                }
            }
        })
        // POST 요청 (1)
//        val params = HashMap<String, Any>()
//        params.put("name", "길홍도")
//        params.put("age", 23)
//        params.put("intro", "안녕하세요")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer> {
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//                Log.d("retrofitt", "fail")
//                call.isCanceled()
//                call.isExecuted()
//                call.cancel() // retry 통신을 막는다.
//            }
//
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "res name:  " + person?.name)
//                    val code = response.code()
//                    Log.d("retrofitt", "res code:  " + code)
//                    val error = response.errorBody()
//                    val header = response.headers()
//                    Log.d("retrofitt", "res header:  " + header)
//                }
//            }
//        })


        // POST 요청 (2)
        val person = PersonFromServer(name = "태연", age = 29, intro = "안녕하세요 김태연입니다.")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                Log.d("retrofitt", "fail")
                call.isCanceled()
                call.isExecuted()
                call.cancel() // retry 통신을 막는다.
            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "res name:  " + person?.name)
                    val code = response.code()
                    Log.d("retrofitt", "res code:  " + code)
                    val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "res header:  " + header)
                }
            }
        })

    }
}
