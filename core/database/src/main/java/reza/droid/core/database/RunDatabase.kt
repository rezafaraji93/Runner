package reza.droid.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import reza.droid.core.database.dao.RunDao
import reza.droid.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {
    abstract val runDao: RunDao
}