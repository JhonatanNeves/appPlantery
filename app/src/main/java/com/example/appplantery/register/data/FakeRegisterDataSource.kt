package com.example.appplantery.register.data

import android.os.Handler
import android.os.Looper
import com.example.appplantery.common.model.DataBase
import com.example.appplantery.common.model.UserAuth
import java.util.UUID

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callback: RegisterCallback) {
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

    override fun create( email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { email == it.email }

            if (userAuth != null) {
                callback.onFailure("User already registered")
            } else {
                val created = DataBase.usersAuth.add(
                    UserAuth(UUID.randomUUID().toString(), name, email, password)
                )

                if (created) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Internal server error")
                }

            }

            callback.onComplete()
        }, 2000)
    }
}