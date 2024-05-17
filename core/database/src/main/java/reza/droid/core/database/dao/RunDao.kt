package reza.droid.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import reza.droid.core.database.entity.RunEntity

@Dao
interface RunDao {

    @Upsert
    suspend fun upsertRun(run: RunEntity)

    @Upsert
    suspend fun upsertRuns(runs: List<RunEntity>)

    @Query("SELECT * FROM runentity ORDER BY dateTimeUtc DESC")
    fun getRuns(): Flow<List<RunEntity>>

    @Query("DELETE FROM runentity WHERE id=:id")
    suspend fun deleteRun(id: String)

    @Query("DELETE FROM runentity")
    suspend fun deleteAllRuns()

}