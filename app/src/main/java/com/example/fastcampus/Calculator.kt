package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calcultator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcultator)

// new + old( new + old)
        var new = "0"
        var old = "0"

        one.setOnClickListener {
            new = new + "1"
            result.setText(new)
        }

        two.setOnClickListener {
            new = new + "2"
            result.setText(new)
        }

        three.setOnClickListener {
            new = new + "3"
            result.setText(new)
        }
        four.setOnClickListener {
            new = new + "4"
            result.setText(new)
        }
        five.setOnClickListener {
            new = new + "5"
            result.setText(new)
        }
        six.setOnClickListener {
            new = new + "6"
            result.setText(new)
        }
        seven.setOnClickListener {
            new = new + "7"
            result.setText(new)
        }

        plus.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            result.setText(old)
        }


        ca.setOnClickListener {
            old ="0"
            new = "0"
            result.setText("0")
        }
    }
}




