package fi.adaptiverunningcoach.app.domain.model

import java.time.LocalDate

data class PlannedWorkout(
    val id: String,
    val date: LocalDate,
    val type: WorkoutType,
    val distanceKm: Double? = null,
    val durationMinutes: Int? = null,
    val description: String = ""
)

enum class WorkoutType {
    RECOVERY,
    EASY,
    LONG,
    INTERVAL,
    TEMPO,
    HILL,
    REST
}