package com.example.hinova.repository.invite

import com.example.hinova.model.InviteAFriendData
import com.example.hinova.network.HinovaApi
import kotlinx.coroutines.flow.flow

class InviteRepositoryImpl(
    private val hinovaApi: HinovaApi
) : InviteRepository {
    override fun inviteFriend(invite: InviteAFriendData) = flow {
        emit(hinovaApi.inviteFriend(invite))
    }
}