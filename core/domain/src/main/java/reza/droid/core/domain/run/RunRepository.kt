package reza.droid.core.domain.run

import kotlinx.coroutines.flow.Flow
import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.EmptyResult

interface RunRepository {
    fun getRuns(): Flow<List<Run>>
    suspend fun fetchRuns(): EmptyResult<DataError>
    suspend fun upsertRun(run: Run, mapPicture: ByteArray): EmptyResult<DataError>
    suspend fun deleteRun(id: RunId)
    suspend fun syncPendingRuns()
}