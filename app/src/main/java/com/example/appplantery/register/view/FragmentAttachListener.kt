package com.example.appplantery.register.view

interface FragmentAttachListener {
    fun goToNameAndPassWordScreen(email: String)
    fun goToWelcomeScreen(name: String)
    fun goToPhotoScreen()
}