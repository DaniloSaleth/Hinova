package com.example.hinova.navigation.home

import android.content.Context
import android.content.Intent
import com.example.hinova.model.UserData

interface HomeNavigation {
    fun getHome(context: Context, userData: UserData): Intent

    companion object {
        const val HOME_DATA_PARAM = "HOME_DATA_PARAM"
    }
}