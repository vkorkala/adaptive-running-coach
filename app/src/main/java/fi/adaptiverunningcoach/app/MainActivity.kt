package fi.adaptiverunningcoach.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fi.adaptiverunningcoach.app.ui.navigation.AppNavigation
import fi.adaptiverunningcoach.app.ui.theme.MukautuvaJuoksuvalmentajaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MukautuvaJuoksuvalmentajaTheme {
                AppNavigation()
            }
        }
    }
}