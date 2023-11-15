package com.example.appplantery.common.base

import com.example.appplantery.login.data.FakeDataSource
import com.example.appplantery.login.data.LoginRepository
import com.example.appplantery.register.data.FakeRegisterDataSource
import com.example.appplantery.register.data.RegisterRepository
import com.example.appplantery.splash.data.FakeLocalDataSource
import com.example.appplantery.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

}