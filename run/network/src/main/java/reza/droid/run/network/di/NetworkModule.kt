package reza.droid.run.network.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.core.domain.run.RemoteRunDataSource
import reza.droid.run.network.KtorRemoteRunDataSource

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}