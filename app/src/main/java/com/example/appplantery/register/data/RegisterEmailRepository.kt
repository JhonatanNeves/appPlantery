package com.example.appplantery.register.data

import com.example.appplantery.login.data.LoginCallback

class RegisterEmailRepository(private val dataSource: RegisterEmailDataSource) {

    fun create(email: String, callback: RegisterEmailCallback) {
        dataSource.create(email, callback)
    }

}