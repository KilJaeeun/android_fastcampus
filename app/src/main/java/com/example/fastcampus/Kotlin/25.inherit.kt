package com.example.fastcampus.Kotlin

// 25. 상속
/*
부모로부터 설명서를 물려받는다!
 */
// 두번 까지는 봐준다.
// 두 번 이상이 넘어가면 리팩토링해라.
fun main(args: Array<String>) {

    val superCar12: SuperCar12 = SuperCar12()
    println(superCar12.drive())
    superCar12.stop()


}


//private 가 디폴트 (외부에서 사용 불가) => open 으로 private 해제
/*
부모 : Car12
자식: SuperCar12, Bus12
자식이 부모를 상속받도록 허용하려면 앞에 open 이 있어야한다가 키워드
 */
open class Car12() {
    open fun drive(): String {
//println("달린다.")
        return " 달린다. "
    }

 open   fun stop() {

    }
}

class SuperCar12() : Car12() {
    override fun drive(): String {
        val run = super.drive()
        return "빨2리 $run"
        //println("빨리 달린다.")
        //super.drive()
    }

    override fun stop() {
        super.stop()
    }
//    fun driveFast() {
//    }
}

class Truck12() : Car12() {

}

class Bus12() : Car12() {

}