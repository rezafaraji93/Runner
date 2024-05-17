package reza.droid.core.database

import android.database.sqlite.SQLiteFullException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import reza.droid.core.database.dao.RunDao
import reza.droid.core.database.mappers.toRun
import reza.droid.core.database.mappers.toRunEntity
import reza.droid.core.domain.run.LocalRunDataSource
import reza.droid.core.domain.run.Run
import reza.droid.core.domain.run.RunId
import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.Result

class RoomLocalRunDataSource(
    private val runDao: RunDao
): LocalRunDataSource {
    override fun getRuns(): Flow<List<Run>> {
        return runDao.getRuns()
            .map { runEntities ->
                runEntities.map { it.toRun() }
            }
    }

    override suspend fun upsertRun(run: Run): Result<RunId, DataError.Local> {
        return try {
            val entity = run.toRunEntity()
            runDao.upsertRun(entity)
            Result.Success(entity.id)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local> {
        return try {
            val entities = runs.map { it.toRunEntity() }
            runDao.upsertRuns(entities)
            Result.Success(entities.map { it.id })
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteRun(id: String) {
        runDao.deleteRun(id)
    }

    override suspend fun deleteAllRuns() {
        runDao.deleteAllRuns()
    }
}