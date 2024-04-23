package com.example.appplantery.profile.data

import android.os.Handler
import android.os.Looper
import com.example.appplantery.common.base.RequestCallback
import com.example.appplantery.common.model.DataBase
import com.example.appplantery.common.model.UserAuth

class ProfileFakeRemoteDataSource : ProfileDataSource{
    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { userUUID == it.uuid}

            if (userAuth !== null) {
                callback.onSuccess(userAuth)
            } else {
                callback.onFailure("User not found")
            }

            callback.onComplete()
        }, 0)
    }
}