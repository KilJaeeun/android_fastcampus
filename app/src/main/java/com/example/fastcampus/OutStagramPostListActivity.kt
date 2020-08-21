package com.example.fastcampus

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutStagramPostListActivity : AppCompatActivity() {

    // glide 로 이미지 넣어주기
    // url 로 이미지 넣기 였다.
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_post_list)

        glide = Glide.with(this)  //glide init
        (application as MasterApplication).service.getAllPosts()
            .enqueue(object : Callback<ArrayList<Post>> {
                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if (response.isSuccessful) {
                        val postList = response.body()
                        val adapter = PostAdapter(
                            postList!!, LayoutInflater.from(this@OutStagramPostListActivity)
                            , glide
                        )

                        post_recycler_view.adapter = adapter
                        post_recycler_view.layoutManager =
                            LinearLayoutManager(this@OutStagramPostListActivity)
                    }
                }
            })


        // 네비바 클릭시 다른 곳으로 가게 시작
        user_info.setOnClickListener { startActivity(Intent(this, OutStagramUserInfo::class.java)) }
        //all_list.setOnClickListener { startActivity(Intent(this, OutStagramUserInfo::class.java)) } => 자기 자신이라 안해도됨
        my_list.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramMyPostListActivity::class.java
                )
            )
        }
        upload.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramUploadActivity::class.java
                )
            )
        }
        // 네비바 클릭시 다른 곳으로 가게 끝
    }

    class PostAdapter(
        var postList: ArrayList<Post>,
        val inflater: LayoutInflater,
        val glide: RequestManager
    ) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val postOwner: TextView
            val postImage: ImageView
            val postContent: TextView

            init {
                postOwner = itemView.findViewById(R.id.post_owner)
                postImage = itemView.findViewById(R.id.post_img)
                postContent = itemView.findViewById(R.id.post_content)
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.outstagram_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.postOwner.setText(postList.get(position).owner)
            holder.postContent.setText(postList.get(position).content)
            holder.postOwner.setText(postList.get(position).owner)
            glide.load(postList.get(position).image).into(holder.postImage)//glide 를 이용해 웹의 이미지 넣기
        }
    }
}
