package com.example.fastcampus.Kotlin

fun main(array: Array<String>) {
    val account: Account = Account("홀기동", "1990.01.01", 1000)

    println(account.checkBalance())
    println(account.save(1000))
    println(account.withdraw(200))
    println(account.checkBalance())

}

class Account {
    val name: String
    val birth: String
    var balance: Int

    constructor(name: String, birth: String, balance: Int) {

        // 기본적인 앙꼬 검사를 해줌 기존 검열!
        this.name = name
        this.birth = birth

        if (balance >= 0) {
            this.balance = balance
        } else {
            this.balance = 0
        }

    }

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }
}


class Account2(val name: String, val birth: String, var balance: Int = 1000) {

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }


}


class Account3(initialBalance: Int) {


    val balance :Int =if(initialBalance>=0)initialBalance else 0
    fun checkBalance(): Int {
        return balance
    }
}