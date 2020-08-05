package com.example.fastcampus

import io.realm.RealmObject

// realm 을 위한 테이블을 만든다.
// open을 해야 외부에서 이것을 사용가능하다.
// var 변수명: 타입 = default

open class School : RealmObject(){
    var name:String?= null
    var location:String?=null
}