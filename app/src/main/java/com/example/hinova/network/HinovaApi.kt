package com.example.hinova.network

import com.example.hinova.model.InviteAFriendData
import com.example.hinova.model.WorkshopResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HinovaApi {
    @GET("Api/Oficina")
    suspend fun getWorkshops(@Query("codigoAssociacao") mobileCode: Int): WorkshopResponse

    @POST("api/Indicacao")
    suspend fun inviteFriend(@Body invite: InviteAFriendData)
}