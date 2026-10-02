package fi.adaptiverunningcoach.app

import android.app.Application
import fi.adaptiverunningcoach.app.di.AppContainer

class AdaptiveRunningCoachApplication : Application() {

    val appContainer = AppContainer()
}