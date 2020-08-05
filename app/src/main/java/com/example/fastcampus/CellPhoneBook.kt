package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class CellPhoneBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cell_phone_book)


        // 아이템 리스트 준비
        val cellList = ArrayList<personCellPhone>()
        for (i in 0 until 10) {
            cellList.add(personCellPhone("인간"  + i , "01040527584",""+i +"번쨰 사람"))
        }


        val container = findViewById<LinearLayout>(R.id.cellphoneview_container)

        val inflater = LayoutInflater.from(this@CellPhoneBook)
        for (i in 0 until cellList.size) {
            val itemView = inflater.inflate(R.layout.item_cellphone, null)
            val NameView = itemView.findViewById<TextView>(R.id.cellphone_name)
            val InitialView = itemView.findViewById<TextView>(R.id.cellphone_initial)
            val CellPhone = itemView.findViewById<TextView>(R.id.cellphone)

            NameView.setText(cellList.get(i).name)
            InitialView.setText(cellList.get(i).initial)
            CellPhone.setText(cellList.get(i).phone)
            container.addView(itemView)
        }

    }


}


class personCellPhone(val initial: String, val phone: String, val name: String) {

}