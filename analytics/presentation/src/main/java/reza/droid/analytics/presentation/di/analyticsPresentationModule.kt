package reza.droid.analytics.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import reza.droid.analytics.presentation.AnalyticsDashboardViewModel

val analyticsPresentationModule = module {
    viewModelOf(::AnalyticsDashboardViewModel)
}