package com.example.appplantery.login

import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String, senha: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()
    }

}