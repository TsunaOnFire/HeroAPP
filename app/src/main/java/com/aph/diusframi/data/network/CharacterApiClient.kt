package com.aph.diusframi.data.network

import com.aph.diusframi.data.network.model.CharacterNetworkModel
import com.aph.diusframi.data.network.responses.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiClient {
    @GET("all.json")
    suspend fun getAllCharacters(): List<CharacterNetworkModel>
}
