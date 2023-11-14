package com.example.appplantery.register.view

import android.net.Uri
import androidx.annotation.StringRes
import com.example.appplantery.common.base.BasePresenter
import com.example.appplantery.common.base.BaseView

interface RegisterPhoto {

    interface Presenter : BasePresenter {
        fun updateUser(photoUri: Uri)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enable: Boolean)

        fun onUpdateFailure(message: String)

        fun onUpdateSuccess()
    }

}