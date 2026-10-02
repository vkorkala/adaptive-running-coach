package fi.adaptiverunningcoach.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import fi.adaptiverunningcoach.app.ui.screens.analysis.AnalysisScreen
import fi.adaptiverunningcoach.app.ui.screens.calendar.CalendarScreen
import fi.adaptiverunningcoach.app.ui.screens.today.TodayScreen

@Composable
fun AppNavigation() {

    var valittuOsio by rememberSaveable {
        mutableIntStateOf(0)
    }

    val todayBackStack = rememberNavBackStack(AppRoute.Today)
    val calendarBackStack = rememberNavBackStack(AppRoute.Calendar)
    val analysisBackStack = rememberNavBackStack(AppRoute.Analysis)

    val nykyinenBackStack = when (valittuOsio) {
        0 -> todayBackStack
        1 -> calendarBackStack
        else -> analysisBackStack
    }

    Scaffold(
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = valittuOsio == 0,
                    onClick = { valittuOsio = 0 },
                    icon = { Text("T") },
                    label = { Text("Tänään") }
                )

                NavigationBarItem(
                    selected = valittuOsio == 1,
                    onClick = { valittuOsio = 1 },
                    icon = { Text("K") },
                    label = { Text("Kalenteri") }
                )

                NavigationBarItem(
                    selected = valittuOsio == 2,
                    onClick = { valittuOsio = 2 },
                    icon = { Text("A") },
                    label = { Text("Analyysi") }
                )
            }
        }
    ) { innerPadding ->

        NavDisplay(
            backStack = nykyinenBackStack,
            onBack = {
                if (nykyinenBackStack.size > 1) {
                    nykyinenBackStack.removeLastOrNull()
                }
            },
            entryProvider = entryProvider {

                entry<AppRoute.Today> {
                    TodayScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                entry<AppRoute.Calendar> {
                    CalendarScreen()
                }

                entry<AppRoute.Analysis> {
                    AnalysisScreen()
                }
            }
        )
    }
}