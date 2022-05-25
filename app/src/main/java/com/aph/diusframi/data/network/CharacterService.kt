package com.aph.diusframi.data.network

import android.util.Log
import com.aph.diusframi.data.model.CharacterModel
import com.aph.diusframi.data.network.model.CharacterNetworkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(private val api:CharacterApiClient){
    suspend fun getCharacters():List<CharacterNetworkModel>{
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharacters()
            //Log.d("Response","Error:"+ response.errorBody()?.charStream()?.readText())
            response ?: emptyList()
        }

    }
}