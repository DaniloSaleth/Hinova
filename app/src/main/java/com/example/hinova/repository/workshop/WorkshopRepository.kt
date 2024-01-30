package com.example.hinova.repository.workshop

import com.example.hinova.model.WorkshopResponse
import kotlinx.coroutines.flow.Flow

interface WorkshopRepository {
    fun getWorkshops(): Flow<WorkshopResponse>
}