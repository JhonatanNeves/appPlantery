package com.example.appplantery.profile.data

import com.example.appplantery.common.base.RequestCallback
import com.example.appplantery.common.model.UserAuth

class ProfileRepository(private val dataSource: ProfileDataSource){
    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>){
        dataSource.fetchUserProfile(userUUID, callback)
    }
}