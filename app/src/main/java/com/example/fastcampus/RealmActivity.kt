package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    /*
    realm 에는 굉장히 많은 method가 있어서 다 살펴ㅂㅎ기는 힘들고
    저장하기, 불러오기, 삭제하기 정도만 구현할 예정
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        /* realm 객체 생성 및 호춯 start */
        setContentView(R.layout.activity_realm)
        Realm.init(this@RealmActivity)
        // 메소드 체이닝: . 다음. 다음 이렇게 .으로 계속 메소드를 체이닝 해나간다.
        val config: RealmConfiguration =
            RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        // migration: 데이터베이스 동기화(데이터베이스 테이블과의 싱크를 맞추기 위해 사용한다.)

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance() // realm 얻기
        /* realm 객체 생성 및 호춯 end */

        /* realm crud start */
        button_save.setOnClickListener {


            realm.executeTransaction {
                /*
                transaction: 작업이 끝나기 전에, 내가 사용하는 테이블로 다른 태스크가 write 못하게 lock 거는 작업
                이전에 했던, sharedPreference 에서 transaction.begin() => commit() 작업을 한 곳에 뭉쳐 놓았다고 생각하면 된다.
                예)
                A 테이블에서 데이터를 가져온다. ==> 10 => 9 (x)
                B 테이블에서 데이터를 가져온다.
                C 테이블에서 데이터를 가져온다.
                세개를 조합한다.
                D 테이블에서 데이터를 저장한다.
                 */
                // 데이터 생성
                with(it.createObject(School::class.java)) {
                    this.name = "어떤대학교"
                    this.location = "서울"
                }


            }

        }
        button_load.setOnClickListener {

            realm.executeTransaction {
                // 다 가져오기
                //it.where(School::class.java).findAll()
                // 처음만 가져오기
                val data = it.where(School::class.java).findFirst()
                Log.d("dataShow", "data:" + data)
            }


        }
        button_delete.setOnClickListener {


            realm.executeTransaction {
                // 다 가져와 지우기
                //it.where(School::class.java).findAll().deleteAllFromRealm()
                // 처음만 가져와 지우기
                val data = it.where(School::class.java).findFirst().deleteFromRealm()
                Log.d("dataShow", "data:" + data)
            }

        }
        /* realm crud end */
    }
}
