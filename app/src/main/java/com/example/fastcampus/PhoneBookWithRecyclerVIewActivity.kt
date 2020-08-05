package com.example.fastcampus

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_v_iew.*

class PhoneBookWithRecyclerVIewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_v_iew)

        // 파라미터 인자 가 많아 지게 되는 경우, ,일부로 파라미터 이름 을 적어주는 것이 좋다.
        // 굳이 파라미터의 이름을 확인하려고  속을 들여다 보지 않아도 돼, 시간을 단축한다.

        /*
        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
        phonebook_recycler_view.layoutManager =
            LinearLayoutManager(this@PhoneBookWithRecyclerVIewActivity)
        */
        // 위의 항목을 줄여쓰기

        with(phonebook_recycler_view) {
            adapter = PhoneBookRecyclerAdapter(
                phonebookList = createFakePhoneBook(30),
                inflater = LayoutInflater.from(this@PhoneBookWithRecyclerVIewActivity),
                activity = this@PhoneBookWithRecyclerVIewActivity
            )
            layoutManager =
                LinearLayoutManager(this@PhoneBookWithRecyclerVIewActivity)
        }


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

}

/*
변수가 많다는 것은 관리해야할 포인트가 많다는 것이다.  이것은 유지보수에 코스트가 든다.
따로 더 쓰이지 않고 , 사용하는 포인트가 1개인 경우, 변수를 직접 대입해 사용하는 것이 낫다.
 */
class PhoneBookRecyclerAdapter(
    val phonebookList: PhoneBooks,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhonBookDetail::class.java)
                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)// activity 가 아니여서 startactitvtiy  를 쓸 수 없다.
//하지만 인자에 이미 activity 가 있기 떄문에 여기서 불러올 수 있다.

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflater.inflate(R.layout.phone_item, parent, false)
        return ViewHolder(view)


    }

    override fun getItemCount(): Int {

        return phonebookList.personList.size


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.personName.setText(phonebookList.personList.get(position).name)
    }
}