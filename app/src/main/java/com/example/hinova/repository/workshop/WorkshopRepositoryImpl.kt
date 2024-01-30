package com.example.hinova.repository.workshop

import com.example.hinova.model.WorkshopResponse
import com.example.hinova.network.HinovaApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WorkshopRepositoryImpl(
    private val hinovaApi: HinovaApi
) : WorkshopRepository {
    override fun getWorkshops(mobileCode: Int): Flow<WorkshopResponse> = flow {
        val data = hinovaApi.getWorkshops(mobileCode)
        emit(data)
    }
}