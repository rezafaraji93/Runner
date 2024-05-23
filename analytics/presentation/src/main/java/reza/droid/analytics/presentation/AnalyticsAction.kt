package reza.droid.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}