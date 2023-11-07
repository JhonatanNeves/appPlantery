package com.example.appplantery.register

import androidx.annotation.StringRes
import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface RegisterEmail {

    interface Presenter : BasePresenter {
        fun create(email: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enable: Boolean)

        fun displayEmailFailure(@StringRes emailError: Int?)

        fun onEmailFailure(message: String)

        fun goToNameAndPassWordScreen(email: String)
    }

}