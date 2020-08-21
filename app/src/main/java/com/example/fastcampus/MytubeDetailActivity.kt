package com.example.fastcampus


import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mytube_detail.*

class MytubeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)


        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@MytubeDetailActivity) //비디오
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaController.show() //비디오 show 재생 비디오는 mediacontroller
        // 전문적인 구글 영상 플레이어
        // Exoplayer
        //drm - digital right management
    }
}