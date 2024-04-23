package com.example.appplantery.profile.data

import com.example.appplantery.common.base.RequestCallback
import com.example.appplantery.common.model.UserAuth
import com.example.appplantery.register.data.RegisterCallback

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>)

}