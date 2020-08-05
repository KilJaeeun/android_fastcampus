package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.intent_first.*

class intent_first : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_first)
        change_activity.setOnClickListener {
//            val intent = Intent(this@intent_first, intent_second::class.java)
//            // key, value 방식 => key, value 를 쌍으로 만들어 저장한다. => dictionary
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)


//            val intent2 = Intent(this@intent_first, intent_second::class.java)
//            //apply => 어떤 작업을 했는지 한 눈에 알 수 있다.
//            //코드 가독성 및 이해도에 유리
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
//            //  startActivity(intent2)
//            startActivityForResult(intent2, 200)


            //암시적 인텐트
            // 클릭하면, 인터넷 브라우저를 열겠따.


            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 200) {
            Log.d("number", requestCode.toString())
            Log.d("number", resultCode.toString())

            val result = data?.getIntExtra("result", 0)
            Log.d("number", result.toString())
        }



        super.onActivityResult(requestCode, resultCode, data)
    }
}
