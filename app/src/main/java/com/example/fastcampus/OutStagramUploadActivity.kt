package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_out_stagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutStagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String // 전역으로 구현 해서 여러 파일 경로에서 사용 가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_upload)

        view_pictures.setOnClickListener {
            // 사진 받아오기
            getPicture()
        }
        upload_post.setOnClickListener {
            uploadPost()
        }

        all_list.setOnClickListener {
            startActivity(Intent(this, OutStagramPostListActivity::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this, OutStagramMyPostListActivity::class.java))
        }
        user_info.setOnClickListener {
            startActivity(Intent(this, OutStagramUserInfo::class.java))
        }
    }


    fun getPicture() {
        // 시스템이 하는 작업
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) // set data 해줘야한다. 외부 저장소 중 이미지만 나온다.
        intent.setType("image/*")
        startActivityForResult(intent, 1000) //결과 받아오기
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val uri: Uri = data!!.data!! // 상대 경로
            // url : 웹페이지 주소, 위치 
            // uri: url 의 상위 개념, 위치 공간, 
            filePath = getImageFilePath(uri) ///(실제) , 절대 경로 알아내는 함수
        }
    }

    fun getImageFilePath(contentUri: Uri): String {
        ///경로 알아내는 함수
        var columnIndex = 0
        // 어렵다.
        val projection = arrayOf(MediaStore.Images.Media.DATA) // 걸러내겠다.
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        // 리스트에서 하나하나 내려가기
        //1
        //2
        //3 <-
        //
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex) //절대 경로 return
    }

    fun uploadPost() {
        //업로드 구현하기 ( 어려움)
        // request 생성 시작
        val file = File(filePath)
        // 이미지는 쪼개서 보내서 multipart 입니다.
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file) // 이미지 타입으로 파일 넣기
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())
        // request 생성 시작 끝
        // 통신 시작
        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    finish()
                    startActivity(
                        Intent(
                            this@OutStagramUploadActivity,
                            OutStagramMyPostListActivity::class.java
                        )
                    )
                }
            }
        })
        // 통신 끝
    }

    fun getContent(): String {
        return content_input.text.toString()
    }

}