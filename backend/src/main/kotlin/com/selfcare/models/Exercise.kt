package com.selfcare.models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val id: String,
    val name: String,
    val sets: Int,
    val reps: String,
    val restSeconds: Int,
    val isHighlighted: Boolean
)


