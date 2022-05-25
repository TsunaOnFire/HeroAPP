package com.aph.diusframi.domain

import android.content.Context
import android.widget.Toast
import com.aph.diusframi.core.InternetConnection
import com.aph.diusframi.data.CharacterRepository
import com.aph.diusframi.data.database.entities.toDatabase
import com.aph.diusframi.domain.model.Character
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetCharacters @Inject() constructor(
    @ApplicationContext private val context: Context,
    private val repository: CharacterRepository
) {
    suspend operator fun invoke():List<Character>{
        if(InternetConnection.checkConnection(context)) {//CHECK CONNECTION
            val characters = repository.getAllCharactersFromApi()
            return if (characters.isNotEmpty()) {
                repository.insertCharacters(characters.map { it.toDatabase() })
                repository.getAllCharactersFromDatabase()
            } else {
                repository.getAllCharactersFromDatabase()
            }
        } else{
            val characters =repository.getAllCharactersFromDatabase()
            if(characters.isEmpty()){
                Toast.makeText(context,"No Internet & No data to recover\nCheck your internet connection and Swipe Down to refresh",
                    Toast.LENGTH_LONG).show()
            }
            return characters
        }
    }
}