package com.example.appplantery.splash.data

import com.example.appplantery.common.model.DataBase

class FakeLocalDataSource : SplashDataSource {
    override fun session(callback: SplashCallback) {
        if (DataBase.sessionAuth != null) {
            callback.onSuccess()
        } else {
            callback.onFailure()
        }
    }
}