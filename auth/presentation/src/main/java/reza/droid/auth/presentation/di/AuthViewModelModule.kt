package reza.droid.auth.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import reza.droid.auth.presentation.register.RegisterViewModel

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
}