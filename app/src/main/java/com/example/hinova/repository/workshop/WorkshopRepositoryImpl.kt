package com.example.hinova.repository.workshop

import com.example.hinova.model.WorkshopResponse
import com.example.hinova.network.HinovaApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WorkshopRepositoryImpl(
    private val hinovaApi: HinovaApi
) : WorkshopRepository {
    override fun getWorkshops(): Flow<WorkshopResponse> = flow {
        emit(hinovaApi.getWorkshops())
    }
}