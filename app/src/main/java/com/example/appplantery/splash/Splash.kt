package com.example.appplantery.splash

import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface Splash {
    interface Presenter : BasePresenter {
        fun authenticated()
    }

    interface View : BaseView<Presenter> {
        fun goToHomeScreen()
        fun goToLoginScreen()
    }
}