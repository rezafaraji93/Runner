package reza.droid.run.data.di

import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module
import reza.droid.run.data.CreateRunWorker
import reza.droid.run.data.DeleteRunWorker
import reza.droid.run.data.FetchRunWorkers

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunWorkers)
    workerOf(::DeleteRunWorker)
}