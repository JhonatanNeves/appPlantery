package com.example.appplantery.register.presentation

import android.util.Patterns
import com.example.appplantery.R
import com.example.appplantery.common.model.UserAuth
import com.example.appplantery.login.Login
import com.example.appplantery.login.data.LoginCallback
import com.example.appplantery.login.data.LoginRepository
import com.example.appplantery.register.RegisterEmail
import com.example.appplantery.register.data.RegisterEmailCallback
import com.example.appplantery.register.data.RegisterEmailRepository

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterEmailRepository
) : RegisterEmail.Presenter {
    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (isEmailValid) {
            view?.showProgress(true)

            repository.create(email, object : RegisterEmailCallback {
                override fun onSuccess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }

    }

    override fun onDestroy() {
        view = null
    }
}