package com.aph.diusframi.data.network.model

import com.aph.diusframi.data.model.*
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class CharacterNetworkModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("powerstats") val powerstats: PowerStatsModel?,
    @SerializedName("appearance") val appearance: AppearanceModel?,
    @SerializedName("biography") val biography: BiographyModel?,
    @SerializedName("work") val work: WorkModel?,
    @SerializedName("connections") val connections: ConnectionsModel?,
    @SerializedName("images") val images: ImagesModel?
    )



