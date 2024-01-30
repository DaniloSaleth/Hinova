package com.example.hinova.navigation.invite

import androidx.fragment.app.Fragment
import com.example.hinova.model.UserData

interface InviteNavigation {
    fun getInviteFragment(userData: UserData): Fragment

    companion object {
        const val INVITE_DATA_PARAM = "INVITE_DATA_PARAM"
    }
}