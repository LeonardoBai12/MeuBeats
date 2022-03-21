package io.lb.meubeats.headset_feature.data.data_source

import io.lb.meubeats.headset_feature.domain.model.Headset
import retrofit2.http.GET

interface HeadsetService {
    @GET("v1/3be97622-50f6-4fcc-8ed5-a3cb74e18c99")
    suspend fun getHeadsets(): List<Headset>
}