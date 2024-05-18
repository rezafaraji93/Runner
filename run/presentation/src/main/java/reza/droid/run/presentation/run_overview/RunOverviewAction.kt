package reza.droid.run.presentation.run_overview

import reza.droid.run.presentation.run_overview.model.RunUi

sealed interface RunOverviewAction {
    data object OnStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
    data class OnDeleteClicked(val runUi: RunUi): RunOverviewAction
}