
package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_open_internet.*

class openInternet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)


        address_edit_txt

        open.setOnClickListener{
            val address = address_edit_txt.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

    address_edit_txt.addTextChangedListener( object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
           Log.d("edit","afterTextChanged: "+s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Log.d("edit","beforeTextChanged: "+s)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Log.d("edit","onTextChanged: "+s)
        }
    })


    }
}
