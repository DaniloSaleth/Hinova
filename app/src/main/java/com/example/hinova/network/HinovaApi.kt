package com.example.hinova.network

import com.example.hinova.model.WorkshopResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HinovaApi {
    @GET("Api/Oficina")
    suspend fun getWorkshops(@Query("codigoAssociacao") mobileCode: Int): WorkshopResponse
}