package com.example.appplantery.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import com.example.appplantery.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextEmail = binding.loginEditEmail
        val editTextPassword = binding.loginEditPassword

        editTextEmail.addTextChangedListener(watcher)
        editTextPassword.addTextChangedListener(watcher)

        val buttonEnter = binding.loginBtnEnter
        buttonEnter.setOnClickListener{
                buttonEnter.showProgress(true)
            binding.loginEditEmailInput
                .error = "Sorry, your email was incorrect"

            binding.loginEditPasswordInput
                .error = "Sorry, your password was incorrect"

            Handler(Looper.getMainLooper()).postDelayed({
                buttonEnter.showProgress(false)
            }, 2000)
        }

    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

}