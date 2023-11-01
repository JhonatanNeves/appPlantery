package com.example.appplantery.login.data

import android.os.Handler
import android.os.Looper

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            if (email == "teste1@gmail.com" && password == "12345678"){
                callback.onSuccess()
            } else {
                callback.onFailure("User not found!")
            }
            callback.onComplete()
        }, 2000)
    }

}