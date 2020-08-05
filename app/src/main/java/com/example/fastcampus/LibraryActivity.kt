package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        Glide.with(this@LibraryActivity).load(
            "https://render-cdn.zepeto.io/20200722/08/39mqABs5sttqgLE7Hj"
        ).centerCrop().into(glide)
        Glide.with(this@LibraryActivity).load(
            "https://render-cdn.zepeto.io/20200722/08/39mqABs5sttqgLE7Hj"
        ).into(glide2)
    }
}
