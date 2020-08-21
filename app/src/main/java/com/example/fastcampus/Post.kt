package com.example.fastcampus

import java.io.Serializable

class Post (
    val owner:String? = null,
    val image:String? = null,
    val content:String? = null
):Serializable