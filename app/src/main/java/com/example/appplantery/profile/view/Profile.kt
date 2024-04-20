package com.example.appplantery.profile.view

import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface Profile {

    interface Presenter : BasePresenter {

        fun fetchUserProfile()
        interface View : BaseView<Presenter> {
            fun showProgress(enabled: Boolean)

        }
    }

}