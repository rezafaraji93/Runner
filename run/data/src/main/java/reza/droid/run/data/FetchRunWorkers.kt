package reza.droid.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import reza.droid.core.domain.run.RunRepository
import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.Result

class FetchRunWorkers(
    context: Context,
    params: WorkerParameters,
    private val runRepository: RunRepository
): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }
        return when(val result = runRepository.fetchRuns()) {
            is reza.droid.core.domain.util.Result.Error -> {
               result.error.toWorkerResult()
            }
            is reza.droid.core.domain.util.Result.Success -> {
                Result.success()
            }
        }
    }
}