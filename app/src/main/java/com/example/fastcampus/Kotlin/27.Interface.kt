package com.example.fastcampus.Kotlin

import android.content.PeriodicSync

/*
27. Interface

-->    인터페이스는 약속이다! => 니가 이것을 구현하면, 너도 이 타입이다!

-->     인터페이스를 상속받게 될경우 , 무조건 인터 페이스 내부의 함수를 구현( 채워) 해줘야한다.
--> 생성자가 없다. -> 인스턴스화 시킬 수 없다. -> 설명서가 아니다.
--> 지침서 -> 니가 이걸 구현하고 싶다면 반드시 아래의 기능을 구현해야한다.

-> 부모자식이 아니라, 이건 인터페이스이고 이건 구현하는 클래스 이런 식으로 표현
-> 부모와 지식, 혹은 자식끼리 진짜 다를 때  인터페이스 사용에 유리하다.
-> 인터페이스는 협업에 유리하다.



* 상속과 다른 점
-> 상속은 조상을 찾아가는 느낌
-> 안터페이스는 종의 특징



28. 인터페이스
-> 인터페이스도 구현이 있는 함수를 만들 수 있다.
// 구현 해도 되고 , 안해도 된다.
->  인터페이스의 구현이 있는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요가 없다.
// 꼭 구현을 요구하면 앞에 abstract 달기
-> 인터페이스에 구현이 없는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 반드시 구현해야한다.
 */


fun main(args: Array<String>){
val student_:Student_ = Student_()
    student_.eat()
    student_.sleep()
}

interface Person_ {
    fun eat(){
        println("먹는다.")
    }
    fun sleep(){
        println("잔다.")
    }

    abstract  fun study() //abstract 반드시 구현해야하는 함수로 들어 준다.
}

class Student_ : Person_ {
    override fun eat() {

    }

    override fun study() {
        TODO("Not yet implemented")
    }

    override fun sleep() {

    }
}

open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}

class Student() : Person() {
}

class Teacher() : Person() {


}

class SoccerPlayer() : Person_ {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
    override fun study() {
        TODO("Not yet implemented")
    }


}