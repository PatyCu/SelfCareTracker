package com.selfcare.models

import kotlinx.serialization.Serializable

@Serializable
data class TrainingPlan(
    val id: String,
    val name: String,
    val daysPerWeek: Int,
    val startDate: String,
    val isActive: Boolean,
    val trainingDays: List<TrainingDay>
)


