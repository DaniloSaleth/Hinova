package com.example.hinova.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.Toast
import com.example.hinova.databinding.ActivityLoginBinding
import com.example.hinova.extension.isValidAuth
import com.example.hinova.infrastructure.BindingActivity
import com.example.hinova.model.UserData
import com.example.hinova.navigation.home.HomeNavigation
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BindingActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModel()
    private val homeNavigation: HomeNavigation by inject()

    override fun onCreateBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.tvRegister.setOnClickListener {
            //Implement the register screen
        }

        binding.btnLogin.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.etLoginCpf.isValidAuth()) -> {
                    toast("Please insert an cpf.")
                }

                TextUtils.isEmpty(binding.etLoginPassword.isValidAuth()) -> {
                    toast("Please insert a Password.")
                }
                else -> {
                    viewModel.login(
                        binding.etLoginCpf.isValidAuth(),
                        binding.etLoginPassword.isValidAuth()
                    )
                }
            }
        }
    }

    private fun setupObservers() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is LoginState.Success -> {
                    startHome(state.result)
                }
                LoginState.EmptyState -> {
                    toast("Empty")
                }
                LoginState.Loading -> {
                    toast("Loading")
                }
                LoginState.Error -> {
                    toast("Error")
                }
            }
        }
    }

    private fun startHome(userData: UserData) {
        val intent = homeNavigation.getHome(this, userData)
        startActivity(intent)
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}