package com.example.hinova.navigation.workshop

import androidx.fragment.app.Fragment
import com.example.hinova.ui.home.fragment.workshop.WorkshopFragment

class WorkshopNavigationImpl : WorkshopNavigation {
    override fun getWorkshopFragment(mobileCode: Int): Fragment {
        return WorkshopFragment()
    }
}