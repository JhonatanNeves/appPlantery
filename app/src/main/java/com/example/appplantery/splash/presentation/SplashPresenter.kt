package com.example.appplantery.splash.presentation

import com.example.appplantery.splash.Splash
import com.example.appplantery.splash.data.SplashCallback
import com.example.appplantery.splash.data.SplashRepository

class SplashPresenter (
    private var view: Splash.View?,
    private var repository: SplashRepository
    ): Splash.Presenter {

    override fun onDestroy() {
        view = null
    }

    override fun authenticated() {
        repository.session(object : SplashCallback{
            override fun onSuccess() {
                view?.goToHomeScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })

    }
}