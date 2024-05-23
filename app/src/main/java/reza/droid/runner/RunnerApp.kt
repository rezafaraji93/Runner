package reza.droid.runner

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import reza.droid.auth.data.di.authDataModule
import reza.droid.auth.presentation.di.authViewModelModule
import reza.droid.core.data.di.coreDataModule
import reza.droid.core.database.di.databaseModule
import reza.droid.run.data.di.runDataModule
import reza.droid.run.di.runPresentationModule
import reza.droid.run.location.di.locationModule
import reza.droid.run.network.di.networkModule
import reza.droid.runner.di.appModule
import timber.log.Timber

class RunnerApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RunnerApp)
            workManagerFactory()
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule,

            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}