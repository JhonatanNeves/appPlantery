package com.example.appplantery.login.data

import android.os.Handler
import android.os.Looper
import com.example.appplantery.common.model.DataBase

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { email == it.email }

            when {
                userAuth == null -> {
                    callback.onFailure("User not found.")
                }
                userAuth.password != password -> {
                    callback.onFailure("The password you’ve entered is incorrect.")
                }
                else -> {
                    DataBase.sessionAuth = userAuth
                    callback.onSuccess(userAuth)
                }
            }

            callback.onComplete()
        }, 2000)
    }
}