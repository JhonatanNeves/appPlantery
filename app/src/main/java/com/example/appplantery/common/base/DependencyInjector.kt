package com.example.appplantery.common.base

import com.example.appplantery.login.data.FakeDataSource
import com.example.appplantery.login.data.LoginRepository
import com.example.appplantery.register.data.FakeRegisterEmailDataSource
import com.example.appplantery.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }

}