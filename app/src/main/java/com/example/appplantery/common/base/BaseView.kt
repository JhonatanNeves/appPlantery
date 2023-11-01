package com.example.appplantery.common.base

import com.example.appplantery.login.Login

interface BaseView<T> {
    var presenter: T
}