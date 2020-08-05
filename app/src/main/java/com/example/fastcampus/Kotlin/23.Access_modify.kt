package com.example.fastcampus.Kotlin

// 23. 접근 제어자

fun main(array: Array<String>) {
    // 어떤 변수에다가 private 이라고 적어주게 되면  외부에서 접근,변경하는 것이 불가능해진다.

    val testAccess: TestAccess = TestAccess("아무개")
//    println(testAccess.name)
//    testAccess.name = "이무개투"
//    println(testAccess.name)

    val reward: Reward = Reward()
    reward.rewardAmount = 3000


    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
}


class Reward() {
    var rewardAmount: Int = 1000
}

class TestAccess {
    private var name: String = "홍길동"

    // 어떤 변수에다가 private 이라고 적어주게 되면  외부에서 접근,변경하는 것이 불가능해진다.
    // 클래스 밖에서 변수로의 접근을  차단한다.
    // pirvate 키워드 떄문에 외부에서 더이사 사용할 수 없다.

    constructor(name: String) {
        this.name = name
    }


    fun changeName(newName: String) {
        this.name = newName
    }


    private fun test() {
        println("테스트")
    }


}


class RunningCar() {

    /*
    제공하고 싶은 기능을 제외한 나머지는 private 으로 한다.
    외부와 내부의 연결을 단절시키는 역할을 한다.
     */
    fun runFast() {
        run()
    }

    private fun run() {

    }
}