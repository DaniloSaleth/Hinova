package com.example.hinova.navigation.workshop

import androidx.fragment.app.Fragment

interface WorkshopNavigation {
    fun getWorkshopFragment(mobileCode: Int): Fragment
}