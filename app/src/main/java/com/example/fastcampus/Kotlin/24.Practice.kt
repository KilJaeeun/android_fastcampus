package com.example.fastcampus.Kotlin

fun main(array: Array<String>) {
    val night = Night(20, 4)
    val monster = Monster(15, 7)
    night.attack(monster)
    monster.attack(night)
    night.attack(monster)
    monster.attack(night)
    night.attack(monster)
    monster.attack(night)
    night.attack(monster)
    monster.attack(night)
    night.attack(monster)
    monster.attack(night)
    night.attack(monster)
    monster.attack(night)


}

/*
항상 클래스 만들때 private, val 로 만들고 필요에 따라 차차 바꿔나가는 것을 원칙으로 한다.
 */
open class Night(private var hp: Int,private  var power: Int) {
    open fun attack(monster: Monster) {
        monster.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) {
            heal()
            println("기사의 현재 체력은 $hp 입니다.")
        } else println("기사가 죽었습니다.")
    }

   private  fun heal() {
        /*
        아무때나 사용하는 것이 아니라,
        공격을 당했을때 죽지 않았다면 힐을한다.
         */
        hp += 3
    }
}

open class Monster(private var hp: Int,private  var power: Int) {
   open fun attack(night: Night) {
        night.defense(power)
    }


   open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("몬스터의 현재 체력은 $hp 입니다.")
        else println("몬스터가 죽었습니다.")
    }
}