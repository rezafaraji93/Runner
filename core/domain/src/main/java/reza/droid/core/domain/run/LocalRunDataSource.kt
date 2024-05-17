package reza.droid.core.domain.run

import kotlinx.coroutines.flow.Flow
import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.Result

typealias RunId = String
interface LocalRunDataSource {
    fun getRuns(): Flow<List<Run>>
    suspend fun upsertRun(run: Run): Result<RunId, DataError.Local>
    suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local>
    suspend fun deleteRun(id: String)
    suspend fun deleteAllRuns()

}