package com.aph.diusframi.data

import com.aph.diusframi.data.database.dao.CharacterDao
import com.aph.diusframi.data.database.entities.CharacterEntity
import com.aph.diusframi.data.model.toRegular
import com.aph.diusframi.data.network.CharacterService
import com.aph.diusframi.domain.model.Character
import com.aph.diusframi.domain.model.toDomain
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    private val characterDao:CharacterDao
) {

    suspend fun getAllCharactersFromApi():List<Character>{
        val response = api.getCharacters()
        //NetworkModel->  InAPPModel   -> ToDomain
        //(Full Info)   (Reduced Info)    (Usable)
        return response.map{it.toRegular().toDomain()}
    }

    suspend fun getAllCharactersFromDatabase():List<Character>{
        val response: List<CharacterEntity> = characterDao.getAllCharacters()

        return response.map{it.toDomain()}
    }

    suspend fun insertCharacters(characters:List<CharacterEntity>){
        characterDao.insertAll(characters)

    }

    suspend fun clearCharacters(){
        characterDao.deleteAllCharacters()
    }

    suspend fun updateCharacter(favorite:Boolean, character:Int){
        characterDao.update(CharacterDao.FavUpdate(character,favorite))
    }

}