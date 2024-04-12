package com.example.appplantery.profile.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.appplantery.R

class ProfileFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}