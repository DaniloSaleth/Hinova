package com.example.hinova.ui.home.fragment.workshop

import com.example.hinova.model.WorkshopResponse

sealed interface WorkshopState {
    data class Success(val result: WorkshopResponse) : WorkshopState
    object EmptyState : WorkshopState
    object Loading : WorkshopState
    object Error : WorkshopState
}