package com.selfcare

import com.selfcare.services.TrainingPlanService
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.Serializable

@Serializable
data class HealthResponse(
    val status: String,
    val service: String
)

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}

fun Application.configureRouting() {
    install(ContentNegotiation) {
        json()
    }

    val trainingPlanService = TrainingPlanService()

    routing {
        get("/api/health") {
            call.respond(HealthResponse(
                status = "ok",
                service = "SelfCareTracker"
            ))
        }

        get("/api/v1/training-plan") {
            val trainingPlan = trainingPlanService.retrieveTrainingPlan()
            call.respond(trainingPlan)
        }
    }
}

