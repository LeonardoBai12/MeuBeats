package io.lb.meubeats.headset_feature.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.lb.meubeats.headset_feature.domain.model.Headset

@Dao
interface HeadsetDao {
    @Query("SELECT * FROM headset")
    fun getAllRecords(): LiveData<List<Headset>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(headset: Headset)

    @Query("DELETE FROM headset")
    fun deleteAllRecords()
}