package com.example.appplantery.profile.presenter

import android.util.Patterns
import com.example.appplantery.R
import com.example.appplantery.common.base.RequestCallback
import com.example.appplantery.common.model.DataBase
import com.example.appplantery.common.model.UserAuth
import com.example.appplantery.profile.Profile
import com.example.appplantery.profile.data.ProfileRepository
import com.example.appplantery.register.RegisterEmail
import com.example.appplantery.register.data.RegisterCallback
import com.example.appplantery.register.data.RegisterRepository
import java.lang.RuntimeException

class ProfilePresenter(
    private var view: Profile.View?,
    private val repository: ProfileRepository
) : Profile.Presenter {

    override fun fetchUserProfile() {
        view?.showProgress(false)
        val userUUID = DataBase.sessionAuth?.uuid ?: throw RuntimeException("User not found")
        repository.fetchUserProfile(userUUID, object : RequestCallback<UserAuth>{
            override fun onSuccess(data: UserAuth) {
                view?.displayUserProfile(data)
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }

        })
    }

    override fun fetchUserLists() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        view = null
    }
}