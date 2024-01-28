package com.example.hinova.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hinova.repository.login.LoginRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> = _state

    fun login(cpf: String, password: String) {

        viewModelScope.launch {
            repository.login(cpf, password)
                .onStart {
                    //Estado de loading
                }
                .catch {
                    //Estado de erro
                }
                .collect { userData ->
                    _state.value = LoginState.Success(userData)
                }
        }
    }


}