package reza.droid.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.core.data.auth.EncryptedSessionStorage
import reza.droid.core.data.networking.HttpClientFactory
import reza.droid.core.data.run.OfflineFirstRunRepository
import reza.droid.core.domain.SessionStorage
import reza.droid.core.domain.run.RunRepository

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}