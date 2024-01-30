package com.example.hinova.navigation.invite

import androidx.fragment.app.Fragment
import com.example.hinova.ui.home.fragment.invite.InviteFragment

class InviteNavigationImpl : InviteNavigation {
    override fun getInviteFragment(): Fragment {
        return InviteFragment()
    }
}