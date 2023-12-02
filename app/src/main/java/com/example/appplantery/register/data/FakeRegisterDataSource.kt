package com.example.appplantery.register.data

import android.net.Uri
import android.os.Handler
import android.os.Looper
import com.example.appplantery.common.model.DataBase
import com.example.appplantery.common.model.Photo
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
                val newUser = UserAuth(UUID.randomUUID().toString(), name, email, password)
                val created = DataBase.usersAuth.add(newUser)

                if (created) {
                    DataBase.sessionAuth = newUser
                    callback.onSuccess()
                } else {
                    callback.onFailure("Internal server error")
                }

            }

            callback.onComplete()
        }, 2000)
    }


    override fun updateUser(photoUri: Uri, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.sessionAuth

            if (userAuth == null) {
                callback.onFailure("User not found")
            } else {
                val newPhoto = Photo(userAuth.uuid,photoUri)
                val created = DataBase.photos.add(newPhoto)

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