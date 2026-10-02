package fi.adaptiverunningcoach.app.di

import fi.adaptiverunningcoach.app.data.repository.InMemoryWorkoutRepository
import fi.adaptiverunningcoach.app.domain.repository.WorkoutRepository

class AppContainer {

    val workoutRepository: WorkoutRepository =
        InMemoryWorkoutRepository()
}