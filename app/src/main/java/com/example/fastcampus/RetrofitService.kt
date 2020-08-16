package com.example.fastcampus

import retrofit2.Call
import retrofit2.http.*

// 하부 url 관리
interface RetrofitService {

    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentEasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>

    // 회원가입
    @POST("rest-auth/registration/")
    @FormUrlEncoded // 필드를 하나하나 작성할때는 무조건 이걸 작성해줘야한다,
    fun register(
        // @Body register: Register (객체를 받지 않는 서버이다.)
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String

    ): Call<User>


}