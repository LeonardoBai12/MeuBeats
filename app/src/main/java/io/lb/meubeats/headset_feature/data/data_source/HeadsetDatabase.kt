package io.lb.meubeats.headset_feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import io.lb.meubeats.headset_feature.domain.model.Headset

@Database(
    entities = [Headset::class],
    version = 1
)
abstract class HeadsetDatabase : RoomDatabase() {
    abstract val headsetDao: HeadsetDao

    companion object {
        const val DATABASE_NAME = "beats_db"
    }
}