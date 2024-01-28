package com.example.hinova.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hinova.databinding.ActivityLoginBinding
import com.example.hinova.extension.isValidAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.tvRegister.setOnClickListener {
            //Implement the register screen
        }

        binding.btnLogin.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.etLoginEmail.isValidAuth()) -> {
                    toast("Please insert an Email.")
                }

                TextUtils.isEmpty(binding.etLoginPassword.isValidAuth()) -> {
                    toast("Please insert a Password.")
                }
                else -> {
                    //Lógica login
                }
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}