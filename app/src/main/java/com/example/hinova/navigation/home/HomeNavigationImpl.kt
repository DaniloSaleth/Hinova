package com.example.hinova.navigation.home

import android.content.Context
import android.content.Intent
import com.example.hinova.model.UserData
import com.example.hinova.navigation.home.HomeNavigation.Companion.HOME_DATA_PARAM
import com.example.hinova.ui.home.HomeActivity

class HomeNavigationImpl : HomeNavigation {
    override fun getHome(context: Context, userData: UserData): Intent {
        val intent = Intent(context, HomeActivity::class.java)
        intent.putExtra(HOME_DATA_PARAM, userData)
        return intent
    }
}