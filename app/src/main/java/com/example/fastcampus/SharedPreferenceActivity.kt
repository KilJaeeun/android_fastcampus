package com.example.fastcampus

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference 에 저장하는 방법
        //   MODE
        //   - MODE_PRIVATE : 생성한 application 에서만 사용가능
        //   - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽을 수만 있다.
        //   - MODE_WORLD_WRITABLE : 다른 application 사용 가능 -> 기록도 가능하다.
        //  - MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
        //  - MODE_APPEND: 기존 preference 에 신규로 추가


        // sp1 -> Sharedpreference
        // (Key, value) -> ("Hello","안녕하세요")
        // sp2 --> Sharedpreference
        //(Key, value) -> ("Hello","안녕하세요11")
        // 위의 둘은 다르고, 서로에게 영향을 미치지 않는다.
        save_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요.")
            editor.putString("goodbye", "안녕가세요.")
            editor.commit()
        }
        load_button.setOnClickListener {

            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음")
            Log.d("key-value", "value1+" + value1)
            Log.d("key-value", "value2+" + value2)
        }
        delete_button.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()

            editor.remove("hello")
            editor.commit()
        }
        delete_all_button.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()

            editor.clear()
            editor.commit()
        }
    }
}
