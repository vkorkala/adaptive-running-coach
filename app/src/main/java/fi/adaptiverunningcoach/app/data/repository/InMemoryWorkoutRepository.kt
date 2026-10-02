package fi.adaptiverunningcoach.app.data.repository

import fi.adaptiverunningcoach.app.domain.model.PlannedWorkout
import fi.adaptiverunningcoach.app.domain.model.WorkoutType
import fi.adaptiverunningcoach.app.domain.repository.WorkoutRepository
import java.time.LocalDate

class InMemoryWorkoutRepository : WorkoutRepository {

    override fun getWorkoutForDate(date: LocalDate): PlannedWorkout? {
        return PlannedWorkout(
            id = "test-1",
            date = date,
            type = WorkoutType.EASY,
            distanceKm = 8.0,
            description = "Rauhallinen peruskestävyyslenkki"
        )
    }
}