package com.selfcare.services

import com.selfcare.models.TrainingPlan
import kotlinx.serialization.json.Json

class TrainingPlanService {
    
    fun retrieveTrainingPlan(): TrainingPlan {
        val jsonContent = this::class.java.classLoader
            .getResource("sample-training-plan.json")
            ?.readText()
            ?: throw IllegalStateException("Training plan JSON file not found")
        
        return Json.decodeFromString<TrainingPlan>(jsonContent)
    }
}

