package reza.droid.run.data.di

import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import reza.droid.core.domain.run.SyncRunScheduler
import reza.droid.run.data.CreateRunWorker
import reza.droid.run.data.DeleteRunWorker
import reza.droid.run.data.FetchRunWorkers
import reza.droid.run.data.SyncRunWorkerScheduler

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunWorkers)
    workerOf(::DeleteRunWorker)
    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}