package com.example.fastcampus.Kotlin

/*
18. Class

 OOP -> Object Oriented Programming(객체 지향 프로그래밍)

 * "객체"란 뭘까!
 -이름이 있는 모든 것
 절차지향 프로그래밍
 - 코드를 위에서부터 아래로  실행하면 문제가 해결된다

 객체 지향 프로그래밍의 해결방법
 - 객체를 만들어서 객체에게 일을 시켜 문제를 해결한다.
 - 선수, 심판, 경기장, 관중 =>   축구 게임


객체를 만드는 방법

- 설명서가 있어야 합니다.

 */

fun main(args: Array<String>) {
// 클래스(설명서)를 통해서 실체를 만드는 방법
// ->  인스턴스화 -> 인스턴스(객체)

    val bigCar = Car("v8 engine", "big")
    //우리가 만든 클래스(설명서)는 자료형이 된다.
    val bigCar1: Car = Car("v8 engine", "big")
    val superCar: SuperCar = SuperCar("good engine", "big", "white")
    var number: Int = 10
    var number1 = 10

    //인스턴스가 가지고 있는 기능을 사용하는 방법
    val runableCar: RunableCar = RunableCar("good engine", "short")
    runableCar.ride()
    runableCar.navi("부산")
    runableCar.drive()


    //인스턴스의 멤버 변수에 접근하는 방법
    val runableCar2: RunableCar2 = RunableCar2("nice engine", "long")
    println(runableCar2.engine)
    println(runableCar2.body)


    //오버로딩
    println()
    val testClass = TestClass()
    testClass.test(1)
    testClass.test(1, 2)

}

/*
* 클래스(설명서) 만드는 방법(1) : 축약
 */
class Car(var engine: String, var body: String) {

}

/*
* 클래스(설명서) 만드는 방법(2) //constructor 사용 : 정식 방법
 */
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        println(engine)
        println(door)
        println(body)
        this.engine = engine
        this.body = body
        this.door = door
    }
}

/*
* 클래스(설명서) 만드는 방법(3) //constructor 사용 : 정식 방법
 -> 1번 방법의 확장
 * 
 * */
class Car1 constructor(var engine: String, var body: String) { //필수
    var door: String = ""//옵션

    // 생성자
    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

/*
클래스(설명서) 만드는 방법(4) => 2번 방법의 확장
 */
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String) {


    fun ride() {
        println("탑승하였습니다.")
    }

    fun drive() {
        println("달립니다!")
    }


    fun navi(destination: String) {
        println("$destination 으로 목적이 설정되었습니다.")
    }

}

class RunableCar2 {
    var engine: String
    var body: String

    //이 인스턴스를 만들면 init 이 먼저 실행된다.
    init {

        //초기 세팅을 할 때 유용하다.
        println("RunableCar2 가 생성되었습니다.")
    }

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    fun ride() {
        println("탑승하였습니다.")
    }

    fun drive() {
        println("달립니다!")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적이 설정되었습니다.")
    }
}


//오버로딩
// ->이름은 같지만 받는 파라미터가 다른 함수
class TestClass() {
    val a: Int = 10
    //  val a : Int = 13
    // 동일한 변수명, 함수명을 같은 클래스 내부에서 원래 작성하면 안되지만,함수의 경우,  아규먼트가 다르면 가능하다.

    fun test(a: Int) {
        println("Up")
    }

    fun test(a: Int, b: Int) {
        println("Down")
    }

}