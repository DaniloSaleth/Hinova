package com.example.hinova.ui.login

import com.example.hinova.model.UserData

sealed interface LoginState {
    data class Success(val result: UserData) : LoginState
    object EmptyState : LoginState
    object Loading : LoginState
    object Error : LoginState
}