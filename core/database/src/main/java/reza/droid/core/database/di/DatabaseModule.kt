package reza.droid.core.database.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.core.database.RoomLocalRunDataSource
import reza.droid.core.database.RunDatabase
import reza.droid.core.domain.run.LocalRunDataSource

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RunDatabase::class.java,
            name = "run.db"
        ).build()
    }

    single { get<RunDatabase>().runDao }

    single { get<RunDatabase>().runPendingSyncDao }

    singleOf(::RoomLocalRunDataSource).bind<LocalRunDataSource>()
}