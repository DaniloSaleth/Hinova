package com.example.hinova.repository.login

import com.example.hinova.model.UserData
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(cpf: String, password: String) : Flow<UserData>
}