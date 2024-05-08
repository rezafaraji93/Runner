package reza.droid.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.core.data.auth.EncryptedSessionStorage
import reza.droid.core.data.networking.HttpClientFactory
import reza.droid.core.domain.SessionStorage

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}