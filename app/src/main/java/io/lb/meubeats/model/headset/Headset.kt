package io.lb.meubeats.model.headset

import java.io.Serializable

data class Headset(
    val name: String,
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