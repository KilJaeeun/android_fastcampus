package com.example.fastcampus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("" + i + "번쨰 자동차", "" + i + "순위 엔진"))
        }
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine
            // 오늘 배운 토스트 메시지. 디버깅에 많이 쓰인다.
            Toast.makeText(this@ListViewActivity, carName + " " + carEngine, Toast.LENGTH_SHORT)
                .show()
        }
    }
}


class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater) :
    BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* val view = layoutInflater.inflate(R.layout.item_view, null)
         var carNameTextView = view.findViewById<TextView>(R.id.car_name)
         var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
         carEngineTextView.setText(carForList.get(position).engine)
         carNameTextView.setText(carForList.get(position).name)
         return view
     */

        //convertView => 이게 도는 역할이다.
        val view: View
        val holder: ViewHolder // 구글 권장사항
        if (convertView == null) {
            Log.d("convert", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            holder.carEngine = view.findViewById(R.id.car_engine)
            holder.carName = view.findViewById(R.id.car_name)
            view.tag = holder
        } else {
            Log.d("convert", "2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)
        return view
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나 (포지션에 해당)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템 뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 사이즈,개수
        return carForList.size
    }
}

class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}