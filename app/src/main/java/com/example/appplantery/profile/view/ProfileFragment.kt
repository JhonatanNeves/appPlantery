package com.example.appplantery.profile.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.example.appplantery.R
import com.example.appplantery.common.base.BaseFragment
import com.example.appplantery.common.base.DependencyInjector
import com.example.appplantery.common.model.Post
import com.example.appplantery.common.model.UserAuth
import com.example.appplantery.databinding.FragmentProfileBinding
import com.example.appplantery.profile.Profile
import com.example.appplantery.profile.presenter.ProfilePresenter

class ProfileFragment: BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile, FragmentProfileBinding::bind
), Profile.View {
    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun setupViews() {
        presenter.fetchUserProfile()
    }

    override fun setUpPresenter() {
        val repository = DependencyInjector.profileRepository()
        presenter = ProfilePresenter(this, repository)
    }

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtUserName?.text = userAuth.name
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun displayEmptyList() {
        TODO("Not yet implemented")
    }

    override fun displayFullList(posts: List<Post>) {
        TODO("Not yet implemented")
    }

    override lateinit var presenter: Profile.Presenter

    override fun getMenu(): Int {
        return R.menu.menu_notification
    }

}