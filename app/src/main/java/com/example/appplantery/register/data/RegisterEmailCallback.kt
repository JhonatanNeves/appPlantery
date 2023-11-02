package com.example.appplantery.register.data

import com.example.appplantery.common.model.UserAuth

interface RegisterEmailCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}