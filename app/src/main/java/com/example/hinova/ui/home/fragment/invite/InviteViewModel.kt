package com.example.hinova.ui.home.fragment.invite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hinova.model.InviteAFriendData
import com.example.hinova.repository.invite.InviteRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class InviteViewModel(
    private val repository: InviteRepository
) : ViewModel() {

    private val _state = MutableLiveData<InviteState>()
    val state: LiveData<InviteState> = _state

    fun inviteFriend(invite: InviteAFriendData) = viewModelScope.launch {
        repository.inviteFriend(invite).onStart {
            _state.value = InviteState.Loading
        }.catch {
            _state.value = InviteState.Error
        }.collect {
            _state.value = InviteState.Success
        }
    }
}