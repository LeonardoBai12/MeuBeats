package io.lb.meubeats.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.headset_feature.domain.model.Headset

@Database(
    entities = [Headset::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val headsetDao: HeadsetDao

    companion object {
        const val DATABASE_NAME = "beats_db"
    }
}