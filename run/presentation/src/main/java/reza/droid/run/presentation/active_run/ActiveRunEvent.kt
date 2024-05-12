package reza.droid.run.presentation.active_run

import reza.droid.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}