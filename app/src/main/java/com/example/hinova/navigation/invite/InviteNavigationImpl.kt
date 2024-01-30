package com.example.hinova.navigation.invite

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hinova.model.UserData
import com.example.hinova.navigation.invite.InviteNavigation.Companion.INVITE_DATA_PARAM
import com.example.hinova.ui.home.fragment.invite.InviteFragment

class InviteNavigationImpl : InviteNavigation {
    override fun getInviteFragment(userData: UserData): Fragment {
        val fragment = InviteFragment()
        val args = Bundle()
        args.putParcelable(INVITE_DATA_PARAM, userData)
        fragment.arguments = args
        return fragment
    }
}