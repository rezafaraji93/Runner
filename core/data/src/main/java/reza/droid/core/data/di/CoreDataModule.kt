package reza.droid.core.data.di

import org.koin.dsl.module
import reza.droid.core.data.networking.HttpClientFactory

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}