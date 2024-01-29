package com.example.hinova.network

import com.example.hinova.model.UserData
import retrofit2.http.GET

interface HinovaApi {
    @GET("api/Oficina")
    suspend fun getWorkshops(): UserData
}