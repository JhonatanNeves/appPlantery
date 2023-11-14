package com.example.appplantery.register.presentation

import android.net.Uri
import com.example.appplantery.R
import com.example.appplantery.register.RegisterNameAndPassword
import com.example.appplantery.register.data.RegisterCallback
import com.example.appplantery.register.data.RegisterRepository
import com.example.appplantery.register.view.RegisterPhoto

class RegisterPhotoPresenter(
    private var view: RegisterPhoto.View?,
    private val repository: RegisterRepository
) : RegisterPhoto.Presenter {

    override fun updateUser(photoUri: Uri) {
        view?.showProgress(true)

        repository.updateUser(photoUri, object : RegisterCallback {
            override fun onSuccess() {
                view?.onUpdateSuccess()
            }

            override fun onFailure(message: String) {
                view?.onUpdateFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}