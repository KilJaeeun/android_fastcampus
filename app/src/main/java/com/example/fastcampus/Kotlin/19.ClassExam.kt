package com.example.fastcampus.Kotlin

fun main(args: Array<String>) {
    var calculator = Calculator(1, 2)
    calculator.plus()
    calculator.minus()
    calculator.mul()
    calculator.divid()
    calculator.remain()

    var fund = Fund("길재은", "970325")
    fund.get(50)
    fund.find()
    fund.put(1000)
    fund.get(50)

    var tv = TV()
    tv.toggle()
    tv.turnChannel()
    tv.turnChannel()
    tv.turnChannel()


}

// 계산기
class Calculator(var a: Int, var b: Int) {
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

class Fund constructor(var name: String, var birth: String) {


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


class TV {
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