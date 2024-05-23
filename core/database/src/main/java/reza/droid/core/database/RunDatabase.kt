package reza.droid.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import reza.droid.core.database.dao.AnalyticsDao
import reza.droid.core.database.dao.RunDao
import reza.droid.core.database.dao.RunPendingSyncDao
import reza.droid.core.database.entity.DeletedRunSyncEntity
import reza.droid.core.database.entity.RunEntity
import reza.droid.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}