package io.lb.meubeats.headset_feature.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.reactivex.rxjava3.core.Flowable

@Dao
interface HeadsetDao {
    @Query("SELECT * FROM headset")
    fun getAllRecords(): Flowable<List<Headset>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(headset: Headset)

    @Query("DELETE FROM headset")
    fun deleteAllRecords()
}