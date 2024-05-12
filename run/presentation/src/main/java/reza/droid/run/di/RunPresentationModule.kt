package reza.droid.run.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import reza.droid.run.domain.RunningTracker
import reza.droid.run.presentation.active_run.ActiveRunViewModel
import reza.droid.run.presentation.run_overview.RunOverviewViewModel

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
    singleOf(::RunningTracker)
}