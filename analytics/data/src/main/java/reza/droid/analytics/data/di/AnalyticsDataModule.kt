package reza.droid.analytics.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.analytics.data.RoomAnalyticsRepository
import reza.droid.analytics.domain.AnalyticsRepository
import reza.droid.core.database.RunDatabase

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}