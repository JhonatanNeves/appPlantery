package com.example.appplantery.splashscreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.appplantery.R
import com.example.appplantery.profile.view.ProfileActivity

class SplashScreenActivity : AppCompatActivity() {

    private val splashTime : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent (this , ProfileActivity::class.java))
            finish()
        }, splashTime)

    }
}