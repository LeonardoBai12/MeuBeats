package io.lb.meubeats.utils

import java.math.RoundingMode
import java.text.DecimalFormat

object DoubleExtensions {
    fun Double?.formatCurrency(): String {
        val df = DecimalFormat("#.00")
        df.roundingMode = RoundingMode.CEILING
        return "R$ ${df.format(this ?: 0.0)}".replace(".",",")
    }
}