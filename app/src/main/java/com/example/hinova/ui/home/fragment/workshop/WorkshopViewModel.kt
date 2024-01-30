package com.example.hinova.ui.home.fragment.workshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hinova.repository.workshop.WorkshopRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WorkshopViewModel(
    private val repository: WorkshopRepository
) : ViewModel() {

    private val _state = MutableLiveData<WorkshopState>()
    val state: LiveData<WorkshopState> = _state

    fun getWorkshops(mobileCode: Int) = viewModelScope.launch {
        repository.getWorkshops(mobileCode).onStart {
            _state.value = WorkshopState.Loading
        }.catch { e ->
            _state.value = WorkshopState.Error(e.message.toString())
        }.collect { userData ->
            _state.value = WorkshopState.Success(userData)
        }
    }
}