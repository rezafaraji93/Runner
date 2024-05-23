package reza.droid.analytics.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import reza.droid.analytics.domain.AnalyticsRepository
import reza.droid.analytics.domain.AnalyticsValues
import reza.droid.core.database.dao.AnalyticsDao
import kotlin.time.Duration.Companion.milliseconds

class RoomAnalyticsRepository(
    private val dao: AnalyticsDao
): AnalyticsRepository {
    override suspend fun getAnalyticsValues(): AnalyticsValues {
        return withContext(Dispatchers.IO) {
            val totalDistance = async { dao.getTotalDistance() }
            val totalTimeMillis = async { dao.getTotalTimeRun() }
            val maxRunSpeed = async { dao.getMaxRunSpeed() }
            val avgDistancePerRun = async { dao.getAverageDistancePerRun() }
            val avgPacePerRun = async { dao.getAveragePacePerRun() }
            AnalyticsValues(
                totalDistanceRun = totalDistance.await(),
                totalTimeRun = totalTimeMillis.await().milliseconds,
                fastestEverRun = maxRunSpeed.await(),
                avgDistancePerRun = avgDistancePerRun.await(),
                avgPacePerRun = avgPacePerRun.await()
            )
        }
    }
}