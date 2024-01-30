package com.example.hinova.repository.invite

import com.example.hinova.model.InviteAFriendData
import kotlinx.coroutines.flow.Flow

interface InviteRepository {
    fun inviteFriend(invite: InviteAFriendData): Flow<Unit>
}