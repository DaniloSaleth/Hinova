package com.example.hinova.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import com.example.hinova.R
import com.example.hinova.databinding.ActivityHomeBinding
import com.example.hinova.infrastructure.BindingActivity
import com.example.hinova.model.UserData
import com.example.hinova.navigation.home.HomeNavigation
import com.example.hinova.navigation.invite.InviteNavigation
import com.example.hinova.navigation.workshop.WorkshopNavigation
import org.koin.android.ext.android.inject

class HomeActivity : BindingActivity<ActivityHomeBinding>() {

    private val workshopNavigation: WorkshopNavigation by inject()
    private val inviteNavigation: InviteNavigation by inject()
    private val params: UserData by lazy {
        intent.getParcelableExtra(HomeNavigation.HOME_DATA_PARAM)!!
    }

    override fun onCreateBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTabLayout()
    }

    private fun setupTabLayout() {
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(workshopNavigation.getWorkshopFragment(params.mobileCode), getString(R.string.workshop))
        pagerAdapter.addFragment(inviteNavigation.getInviteFragment(params), getString(R.string.invite))

        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}