package com.example.fastcampus

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Cotext_basic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.context_for_basic)

        val context: Cotext_basic= this
      //  val applicationContext: android.content.Context = getApplicationContext() as Context
        val applicationContext = getApplicationContext()
    }
}
