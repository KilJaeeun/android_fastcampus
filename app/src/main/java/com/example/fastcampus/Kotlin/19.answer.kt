package com.example.fastcampus.Kotlin


fun main(args: Array<String>) {

    var calculator = Calculator1(4, 5)
    calculator.plus()
    calculator.minus()
    calculator.mul()
    calculator.divid()
    calculator.remain()

    var fund = Fund1("길재은", "970325")
    fund.get(50)
    fund.find()
    fund.put(1000)
    fund.get(50)

    var tv = TV1()
    tv.toggle()
    tv.turnChannel()
    tv.turnChannel()
    tv.turnChannel()


    var calculator4 = Calculator2()
    println(calculator4.plus(1, 2, 3, 4, 5))
    println(calculator4.minus(20, 2, 3, 4))
    println(calculator4.mul(1, 2, 3, 4, 5))
    println(calculator4.divid(1000, 2, 3, 4, 5))




    println()
    // 중요!
    val calculator3 = Calculator3(3)
    calculator3.plus(5).minus(5)
    println(calculator3.initialValue)
    // 체이닝  펑션을 계속 이어짤 수 있게 짜는 것이 중요하다.


}

// 계산기 가장 쉬운 반법(1)
class Calculator1(var a: Int, var b: Int) {
    fun plus() {
        println("${this.a}+${this.b}=${this.a + this.b}")
    }

    fun minus() {
        println("${this.a}-${this.b}=${this.a - this.b}")
    }

    fun mul() {
        println("${this.a}*${this.b}=${this.a * this.b}")
    }

    fun divid() {
        println("${this.a}/${this.b}=${this.a / this.b}")
    }

    fun remain() {
        println("${this.a}%${this.b}=${this.a % this.b}")
    }
}


// 계산기 (2)

class Calculator2() {

    fun plus(vararg numbers: Int): Int {
        var result = 0
        numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for (i in 1 until numbers.size) {
            result -= numbers[i]
        }
        return result
    }


    fun mul(vararg numbers: Int): Int {

        var result: Int = 1
        numbers.forEach {

            if (it != 0) {
                result *= it
            }
        }
        return result
    }


    fun divid(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if (value * index != 0) {
                result /= value
            }
        }
        return result
    }


}


class Calculator3(val initialValue: Int) {


    fun plus(number: Int): Calculator3 {
        val result = this.initialValue + number
        return Calculator3(result)
    }

    fun minus(number: Int): Calculator3 {
        val result = this.initialValue - number
        return Calculator3(result)
    }

    fun mul(number: Int): Calculator3 {
        val result = this.initialValue * number
        return Calculator3(result)
    }

    fun divid(number: Int): Calculator3 {
        val result = this.initialValue / number
        return Calculator3(result)
    }
}


class Fund1 constructor(var name: String, var birth: String) {


    var money: Int = 0

    constructor(name: String, birth: String, money: Int) : this(name, birth) {
        this.money = money
    }

    init {
        println("계좌를 생성했습니다! ")

    }

    fun find(): String {
        println("현재 잔고는 ${this.money} 입니다.")
        return "현재 잔고는 ${this.money} 입니다."
    }

    fun get(getMoney: Int) {

        if (this.money - getMoney < 0) {
            println("인출 금액이 너무 큽니다.")
            return
        }
        this.money -= getMoney
        println("원금: ${this.money + getMoney} , 인출금 : ${getMoney}   -> ${this.find()}")
    }


    fun put(putMoney: Int) {
        this.money += putMoney
        println("원금: ${this.money - putMoney} , 인출금 : ${putMoney}   ->${this.find()}")
    }

}


class TV1 {
    var channels = charArrayOf('S', 'M', 'K')
    var currentChannel = 0
    var status = "off"

    constructor() {
        this.channels = channels
        this.status = status
        this.currentChannel = currentChannel
    }


    fun toggle() {
        when (this.status) {
            "on" -> {
                this.status = "off"
                println("tv 를 껐습니다.")
            }
            "off" -> {
                this.status = "on"
                println("tv를 켰습니다.")
            }
        }
    }

    fun turnChannel() {
        if (this.status == "on") {

            when (this.currentChannel) {
                0 -> {
                    this.currentChannel = 1
                    println("채널을 바꿨습니다. 현재 채널은 ${this.channels[currentChannel]} 입니다.")
                }
                1 -> {
                    this.currentChannel = 2
                    println("채널을 바꿨습니다. 현재 채널은 ${this.channels[currentChannel]} 입니다.")
                }
                2 -> {
                    this.currentChannel = 0
                    println("채널을 바꿨습니다. 현재 채널은 ${this.channels[currentChannel]} 입니다.")
                }
            }
        }
    }


}