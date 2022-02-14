package io.lb.meubeats.utils

import java.math.RoundingMode
import java.text.DecimalFormat

object DoubleHelper {
    fun formatCurrency(value: Double?): String {
        val df = DecimalFormat("#.00")
        df.roundingMode = RoundingMode.CEILING
        return "R$ ${df.format(value)}".replace(".",",")
    }
}