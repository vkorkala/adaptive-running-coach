package fi.adaptiverunningcoach.app.domain.repository

import fi.adaptiverunningcoach.app.domain.model.PlannedWorkout
import java.time.LocalDate

interface WorkoutRepository {

    fun getWorkoutForDate(date: LocalDate): PlannedWorkout?
}