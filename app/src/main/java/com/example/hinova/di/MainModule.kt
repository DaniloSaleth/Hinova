package com.example.hinova.di

import com.example.hinova.infrastructure.api.Constants.BASE_URL
import com.example.hinova.navigation.home.HomeNavigation
import com.example.hinova.navigation.home.HomeNavigationImpl
import com.example.hinova.navigation.invite.InviteNavigation
import com.example.hinova.navigation.invite.InviteNavigationImpl
import com.example.hinova.navigation.workshop.WorkshopNavigation
import com.example.hinova.navigation.workshop.WorkshopNavigationImpl
import com.example.hinova.network.HinovaApi
import com.example.hinova.repository.login.LoginRepository
import com.example.hinova.repository.login.LoginRepositoryImpl
import com.example.hinova.repository.workshop.WorkshopRepository
import com.example.hinova.repository.workshop.WorkshopRepositoryImpl
import com.example.hinova.ui.home.fragment.workshop.WorkshopViewModel
import com.example.hinova.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val loadNavigation = module {
    single<HomeNavigation> { HomeNavigationImpl() }
    single<WorkshopNavigation> { WorkshopNavigationImpl() }
    single<InviteNavigation> { InviteNavigationImpl() }
}

val loadViewModels = module {
    viewModel { LoginViewModel(get()) }
    viewModel { WorkshopViewModel(get()) }
}

val loadRepositories = module {
    factory<LoginRepository> { LoginRepositoryImpl() }
    factory<WorkshopRepository> { WorkshopRepositoryImpl(get()) }
}

val loadServices = module {
    single(named("BASE_URL")) {
        BASE_URL
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single{
        get<Retrofit>().create(HinovaApi::class.java)
    }
}