package com.example.appplantery.login.presentation

import android.util.Patterns
import com.example.appplantery.R
import com.example.appplantery.login.Login

class LoginPresenter (
    private var view: Login.View?
    ) : Login.Presenter {

    override fun login(email: String, password: String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (password.length < 8) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

    }

    override fun onDestroy() {
        view = null
    }
}