package com.example.hinova.network

import com.example.hinova.model.WorkshopResponse
import retrofit2.http.GET

interface HinovaApi {
    @GET("Api/Oficina")
    suspend fun getWorkshops(): WorkshopResponse
}