package com.selfcare.models

import kotlinx.serialization.Serializable

@Serializable
data class TrainingDay(
    val id: String,
    val dayOfWeek: Int,
    val workoutType: String,
    val location: String,
    val highlightedExercises: List<String>,
    val exercises: List<Exercise>
)


