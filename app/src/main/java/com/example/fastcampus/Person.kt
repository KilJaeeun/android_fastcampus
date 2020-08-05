package com.example.fastcampus

import java.io.Serializable

class PersonFromServer(
    val id: Int? = null,
    val name: String? = null,
    val age: Int? = null,
    val intro: String? = null
):Serializable