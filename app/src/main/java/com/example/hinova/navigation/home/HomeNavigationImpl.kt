package com.example.hinova.navigation.home

import android.content.Context
import android.content.Intent
import com.example.hinova.model.UserData
import com.example.hinova.navigation.home.HomeNavigation.Companion.HOME_DATA_PARAM
import com.example.hinova.ui.home.HomeActivity

class HomeNavigationImpl : HomeNavigation {
    override fun getHome(context: Context, userData: UserData): Intent {
        return Intent(context, HomeActivity::class.java).apply {
            putExtra(HOME_DATA_PARAM, userData)
        }
    }
}