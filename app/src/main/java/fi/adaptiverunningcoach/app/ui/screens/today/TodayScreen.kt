package fi.adaptiverunningcoach.app.ui.screens.today

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.adaptiverunningcoach.app.domain.model.WorkoutType
import fi.adaptiverunningcoach.app.viewmodel.TodayViewModel


@Composable
fun TodayScreen(
    modifier: Modifier = Modifier,
    viewModel: TodayViewModel = viewModel(factory = TodayViewModel.Factory)
) {
    val workout = viewModel.uiState.workout
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Mukautuva juoksuvalmentaja",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Harjoitteluohjelma, palautuminen ja olosuhteet yhdessä paikassa.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Tämän päivän harjoitus",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = workout?.let { "${it.distanceKm} km" }
                        ?: "Ei harjoitusta vielä lisättynä.",
                    style = MaterialTheme.typography.bodyMedium
                )
                workout?.let {
                    Text(
                        text = it.type.toDisplayName(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                workout?.let {
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Palautuminen",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Palautumistiedot eivät ole vielä yhdistettynä.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Toiminnallisuus lisätään myöhemmin.
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aloita")
        }
    }
}

private fun WorkoutType.toDisplayName(): String {
    return when (this) {
        WorkoutType.RECOVERY -> "Palauttava"
        WorkoutType.EASY -> "Kevyt"
        WorkoutType.LONG -> "Pitkä"
        WorkoutType.INTERVAL -> "Intervalli"
        WorkoutType.TEMPO -> "Tempo"
        WorkoutType.HILL -> "Mäkiharjoitus"
        WorkoutType.REST -> "Lepo"
    }
}