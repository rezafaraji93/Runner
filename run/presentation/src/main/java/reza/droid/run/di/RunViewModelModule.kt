package reza.droid.run.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import reza.droid.run.presentation.run_overview.RunOverviewViewModel

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
}