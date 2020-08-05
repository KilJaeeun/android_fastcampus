package com.example.fastcampus.Kotlin

fun main(args: Array<String>) {
    val channels = listOf<String>("K", "M", "S")
    val tv = TV2(channels)
    tv.switch()
    println(tv.onOrOff)
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
}


class TV2(val channels: List<String>) {
    var onOrOff: Boolean = false // true -> on, false=> off


    // 아주아주 중요!!!! 들여쓰기가 있다는 점 숙지하자

    var currentChannelNumber = 0
        set(value) {      // currentChannelNumber 가 바뀌면 호출되는 함수 set
            /*
            set 함수 내부에서 본인을 호출하게 될 경우, 무한루프에 빠지게 된다.
            항상 이용에 주의하자 => 본인 자리에 field 라는 변수를 사용
             */
            field = value
            if (field > 2) {
                field = 0
            }
            if (field < 0) {
                field = 2
            }

        }
        get() { //  currentChannelNumber 가 호출될 경우, 호출되는 함수 get
            println("호출되었습니다.")
            return field
        }
    fun switch() {
        onOrOff = !onOrOff
    }


    fun checkCurrentChannel(): String {
        return channels[currentChannelNumber]
    }

    fun channelUp() {
        currentChannelNumber += 1
    }

    fun channelDown() {
        currentChannelNumber -= 1
    }
}