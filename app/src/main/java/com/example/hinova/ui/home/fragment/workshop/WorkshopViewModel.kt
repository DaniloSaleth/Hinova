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

    init {
        getWorkshops()
    }

    private fun getWorkshops() {
        viewModelScope.launch {
            repository.getWorkshops()
                .onStart {
                    //Estado de loading
                }
                .catch {
                    //Estado de erro
                }
                .collect { userData ->
                    _state.value = WorkshopState.Success(userData)
                }
        }
    }
}