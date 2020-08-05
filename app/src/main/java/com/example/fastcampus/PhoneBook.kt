package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)


    }


    fun createFakePhoneBook(
        fakeNumber: Int = 10,
        phoneBooks: PhoneBooks = PhoneBooks()
    ): PhoneBooks {
        for (i in 0 until fakeNumber) {
            phoneBooks.addPerson(Person(name = "" + i + "번쨰 사람", number = "" + i + "번쨰 사람의 전화번호"))
        }
        return phoneBooks
    }

    fun createPhoneBookList(phoneBooks: PhoneBooks) {
        val layoutInflater = LayoutInflater.from(this@PhoneBook)

        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)

        for (i in 0 until phoneBooks.personList.size) {
            val view = layoutInflater.inflate(R.layout.phone_item, null) // 아이템 한 칸을 의미한다.

            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBooks.personList.get(i).name)
            addSetOnClickListener(phoneBooks.personList.get(i), view)
            container.addView(view)

        }

    }

    // 클릭하면 디테일 페이지로 가게 하는 핸들러
    fun addSetOnClickListener(person: Person, view: View) {


        view.setOnClickListener {
            val intent = Intent(this@PhoneBook, PhonBookDetail::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)


        }

    }


}

class PhoneBooks() {
    // 전화번호부
    val personList = ArrayList<Person>()
    fun addPerson(person: Person) {
        personList.add(person)
    }
}


class Person(val name: String, var number: String) {}


