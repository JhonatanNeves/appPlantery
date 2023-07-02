package com.example.appplantery.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.appplantery.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_password)
        findViewById<AppCompatButton>(R.id.login_btn_enter).isEnabled =
            editTextPassword.text?.isEmpty() ?: false

//        findViewById<TextInputLayout>(R.id.login_edit_email_input)
//                .error = "Sorry, your email was incorrect."
    }
}