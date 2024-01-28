package com.example.hinova.repository.login

import com.example.hinova.model.UserData
import com.example.hinova.network.loginMock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

class LoginRepositoryImpl : LoginRepository {
    override fun login(cpf: String, password: String): Flow<UserData> = flow {
        if (cpf == "78885983073" && password == "37038958887") {
            emit(loginMock)
        } else {
            //Realizar requisição
        }
    }.transform {
        emit(it)
    }.catch {
        throw it
    }
}