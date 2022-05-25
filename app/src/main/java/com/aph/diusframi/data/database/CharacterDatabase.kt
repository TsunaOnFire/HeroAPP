package com.aph.diusframi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aph.diusframi.data.database.entities.CharacterEntity
import com.aph.diusframi.data.database.dao.CharacterDao

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDao
}