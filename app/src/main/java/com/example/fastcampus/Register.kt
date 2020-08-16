package com.example.fastcampus

import java.io.Serializable

class Register(
    var username: String? = null,
    var password1: String? = null,
    var password2: String? = null
) : Serializable