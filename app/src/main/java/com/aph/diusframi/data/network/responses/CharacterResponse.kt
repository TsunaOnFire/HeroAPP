package com.aph.diusframi.data.network.responses

import com.aph.diusframi.data.model.CharacterModel
import com.google.gson.annotations.SerializedName

//Useful to parse the WS result in this case trim the result to exclude the uneccessary fields
// Currently NOT USED
data class CharacterResponse(
    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var totalResults: Int,
    @SerializedName("characters") var characters: List<CharacterModel>?
    )
