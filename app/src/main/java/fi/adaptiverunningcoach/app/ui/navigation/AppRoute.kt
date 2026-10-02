package fi.adaptiverunningcoach.app.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute : NavKey {

    @Serializable
    data object Today : AppRoute

    @Serializable
    data object Calendar : AppRoute

    @Serializable
    data object Analysis : AppRoute
}