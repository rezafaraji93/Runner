package reza.droid.run.location.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.run.domain.LocationObserver
import reza.droid.run.location.AndroidLocationObserver

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}