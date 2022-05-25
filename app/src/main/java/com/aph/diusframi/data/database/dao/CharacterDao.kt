package com.aph.diusframi.data.database.dao

import androidx.room.*
import com.aph.diusframi.data.database.entities.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character_table ORDER BY id ASC")
    suspend fun getAllCharacters():List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characters:List<CharacterEntity>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAllCharacters()



    @Update(entity = CharacterEntity::class)
    suspend fun update(obj: FavUpdate)

    @Entity
    public class FavUpdate{
        @ColumnInfo(name = "id")var id:Int?=0;
        @ColumnInfo(name = "fav")var fav: Boolean = false;
        constructor(i_id:Int,i_fav:Boolean){
            id=i_id;
            fav =i_fav;
        }
    }

}