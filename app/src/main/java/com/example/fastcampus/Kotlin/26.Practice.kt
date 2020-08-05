package com.example.fastcampus.Kotlin

/*
과제
Night, monster(부모)
super Night, Super monster(자식)
 */


fun main(array: Array<String>) {
    val night = SuperNight(200, 10)
    val monster = SuperMonster(205, 10, "gomugomu")
    monster.attack(night)
    monster.bite(night)
    monster.bite(monster)
}
/*
상속이 만들어낸 특징
-> 자식 클래스는 부모 클래스의 타입이다.
-> 부모 클래스는 자식 클래스의 타입이 아니다.
 */

// 자식 클래스가 인스턴스화되기 위해서는 부모클래스가 선해돼서 인스턴스화 되어야한다.
/*
항상 클래스 만들때 private, val 로 만들고 필요에 따라 차차 바꿔나가는 것을 원칙으로 한다.
 */


open class Character(var hp: Int, val power: Int) {

    fun attack(character: Character, power: Int=this.power) {
        character.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp 입니다.")
        else println("사망했습니다.")

    }

}


class SuperNight(hp: Int, power: Int) : Character(hp, power) {


    val defensePower = 2

    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}

class SuperMonster(hp: Int, power: Int, val item: String) : Character(hp, power) {
    fun bite(character: Character) {
        super.attack(character, power+2)
    }
}