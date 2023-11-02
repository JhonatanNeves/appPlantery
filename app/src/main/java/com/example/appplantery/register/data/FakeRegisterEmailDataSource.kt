package com.example.appplantery.register.data

import android.os.Handler
import android.os.Looper
import com.example.appplantery.common.model.DataBase

class FakeRegisterEmailDataSource : RegisterEmailDataSource {
    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSuccess()
            } else {
                callback.onFailure("User already registered")
            }

            callback.onComplete()
        }, 2000)
    }
}