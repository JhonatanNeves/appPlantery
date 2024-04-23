package com.example.appplantery.profile.view

import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView
import com.example.appplantery.common.model.Post
import com.example.appplantery.common.model.UserAuth

interface Profile {

    interface Presenter : BasePresenter {

        fun fetchUserProfile()
        fun fetchUserLists()
    }
        interface View : BaseView<Presenter> {
            fun showProgress(enabled: Boolean)
            fun displayUserProfile(userAuth: UserAuth)
            fun displayRequestFailure(message: String)
            fun displayEmptyList()
            fun displayFullList(posts: List<Post>)

        }


}