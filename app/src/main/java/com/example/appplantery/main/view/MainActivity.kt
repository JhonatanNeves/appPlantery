@file:Suppress("DEPRECATION")

package com.example.appplantery.main.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.appplantery.R
import com.example.appplantery.databinding.ActivityMainBinding
import com.example.appplantery.home.view.HomeFragment
import com.example.appplantery.profile.view.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

    class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: Fragment
    private lateinit var calendarFragment: Fragment
    private lateinit var myPlantsFragment: Fragment
    private lateinit var profileFragment: Fragment
    private var currentFragment: Fragment? = null
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)

            window.statusBarColor = ContextCompat.getColor(this, R.color.beige_light)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()

        binding.mainBottomNav.setOnNavigationItemSelectedListener (this)
        binding.mainBottomNav.selectedItemId = R.id.menu_bottom_home

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_bottom_home -> {
                currentFragment = homeFragment
            }

            R.id.menu_bottom_profile -> {
                currentFragment = profileFragment
            }
        }

        currentFragment?.let {
            if (supportFragmentManager.findFragmentById(R.id.main_fragment) == null) {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.main_fragment, it)
                    commit()
                }
            } else {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_fragment, it)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        return true
    }
}