package io.lb.meubeats.headset_feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Headset(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val name: String = "",
    var soundCapture: String? = null,
    var powerSupply: String? = null,
    var compatibility: String? = null,
    var connection: String? = null,
    var height: Double? = null,
    var autonomy: Double? = null,
    var averageScore: Double? = null,
    var price: Double? = null,
    var reviews: Int? = null,
) : Serializable

class InvalidHeadsetException(message: String) : Exception(message)
