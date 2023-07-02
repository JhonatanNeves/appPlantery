package com.example.appplantery.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import com.example.appplantery.R
import com.example.appplantery.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.net.BindException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_password)
        findViewById<AppCompatButton>(R.id.login_btn_enter).isEnabled =
            editTextPassword.text?.isEmpty() ?: false

        findViewById<TextInputLayout>(R.id.login_edit_email_input)
                .error = "Sorry, your email was incorrect."
    }
}