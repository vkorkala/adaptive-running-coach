package fi.adaptiverunningcoach.app.ui.screens.today

import fi.adaptiverunningcoach.app.domain.model.PlannedWorkout

data class TodayUiState(
    val workout: PlannedWorkout? = null
)