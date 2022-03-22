package io.lb.meubeats.utils

import io.lb.meubeats.headset_feature.domain.model.Headset

object ResourceCreator {
    fun exampleHeadsets(): List<Headset> {
        return arrayListOf(
            simpleHeadset(1),
            simpleHeadset(3),
            simpleHeadset(2),
            simpleHeadset(8),
            simpleHeadset(7),
            simpleHeadset(5),
            simpleHeadset(6),
            simpleHeadset(4),
        )
    }

    fun simpleHeadset(model: Int): Headset {
        return Headset(
            model,
            "Fone Modelo $model",
            soundCapture = "Semi ativa",
            powerSupply = "Bateria",
            compatibility = "Bluetooth 4.1",
            connection = "Bluetooth",
            height = 16.8,
            autonomy = 16.0,
            averageScore = 4.5,
            price = 22.5,
            reviews  = 89,
        )
    }
}