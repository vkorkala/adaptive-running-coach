package fi.adaptiverunningcoach.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import fi.adaptiverunningcoach.app.AdaptiveRunningCoachApplication
import fi.adaptiverunningcoach.app.domain.repository.WorkoutRepository
import fi.adaptiverunningcoach.app.ui.screens.today.TodayUiState
import java.time.LocalDate

class TodayViewModel(
    workoutRepository: WorkoutRepository
) : ViewModel() {

    var uiState by mutableStateOf(
        TodayUiState(
            workout = workoutRepository.getWorkoutForDate(LocalDate.now())
        )
    )
        private set

    companion object {
        val Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                require(modelClass.isAssignableFrom(TodayViewModel::class.java)) {
                    "Tuntematon ViewModel: ${modelClass.name}"
                }

                val application = checkNotNull(
                    extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                )

                val app = application as AdaptiveRunningCoachApplication

                @Suppress("UNCHECKED_CAST")
                return TodayViewModel(
                    app.appContainer.workoutRepository
                ) as T
            }
        }
    }
}