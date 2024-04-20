package com.example.appplantery.profile.view

import android.os.Bundle
import android.view.*
import com.example.appplantery.R
import com.example.appplantery.common.base.BaseFragment
import com.example.appplantery.databinding.FragmentProfileBinding

class ProfileFragment: BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile, FragmentProfileBinding::bind){

    override lateinit var presenter: Profile.Presenter


    override fun setupViews() {
    }

    override fun setUpPresenter() {

    }

    override fun getMenu(): Int {
        return R.menu.menu_notification
    }

}