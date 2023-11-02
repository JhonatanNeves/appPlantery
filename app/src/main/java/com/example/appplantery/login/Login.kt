package com.example.appplantery.login

import androidx.annotation.StringRes
import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String, senha: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }

}