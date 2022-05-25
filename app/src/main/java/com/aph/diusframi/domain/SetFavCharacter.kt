package com.aph.diusframi.domain

import android.content.Context
import android.widget.Toast
import com.aph.diusframi.core.InternetConnection
import com.aph.diusframi.data.CharacterRepository
import com.aph.diusframi.data.database.entities.toDatabase
import com.aph.diusframi.domain.model.Character
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SetFavCharacter @Inject() constructor(
    private val repository: CharacterRepository
) {
    suspend fun invoke(fav: Boolean,id: Int){
        repository.updateCharacter(fav,id);
    }

}