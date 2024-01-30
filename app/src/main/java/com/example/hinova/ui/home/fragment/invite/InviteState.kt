package com.example.hinova.ui.home.fragment.invite

sealed interface InviteState {
    object Success : InviteState
    object Loading : InviteState
    object Error : InviteState
}