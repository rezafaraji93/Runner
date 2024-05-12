package reza.droid.runner

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import reza.droid.auth.data.di.authDataModule
import reza.droid.auth.presentation.di.authViewModelModule
import reza.droid.core.data.di.coreDataModule
import reza.droid.run.di.runViewModelModule
import reza.droid.runner.di.appModule
import timber.log.Timber

class RunnerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RunnerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runViewModelModule
            )
        }
    }
}