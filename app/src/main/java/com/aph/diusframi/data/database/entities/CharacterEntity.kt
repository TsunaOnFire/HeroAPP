package com.aph.diusframi.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aph.diusframi.domain.model.Character
import com.google.gson.JsonObject

@Entity(tableName = "character_table")
data class CharacterEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")val id: Int? =0,
    @ColumnInfo(name = "fav")val fav: Boolean?,
    @ColumnInfo(name = "name")val name: String?,
    @ColumnInfo(name = "image")val image: String?,
    //POWERSTATS
    @ColumnInfo(name = "intelligence")val intelligence:Int?,
    @ColumnInfo(name = "strength")val strength:Int?,
    @ColumnInfo(name = "speed")val speed:Int?,
    @ColumnInfo(name = "durability")val durability:Int?,
    @ColumnInfo(name = "power")val power:Int?,
    @ColumnInfo(name = "combat")val combat:Int?,
    //APPEARANCE
    @ColumnInfo(name = "gender")val gender: String?,
    @ColumnInfo(name = "race")val race: String?,
    @ColumnInfo(name = "eyeColor")val eyeColor: String?,
    @ColumnInfo(name = "hairColor")val hairColor: String?,
    //BIOGRAPHY
    @ColumnInfo(name = "fullName")val fullName: String?,
    @ColumnInfo(name = "alterEgos")val alterEgos: String?,
    @ColumnInfo(name = "placeOfBirth")val placeOfBirth: String?,
    @ColumnInfo(name = "firstAppearance")val firstAppearance: String?,
    @ColumnInfo(name = "publisher")val publisher: String?,
    @ColumnInfo(name = "alignment")val alignment: String?


    )

fun Character.toDatabase() = CharacterEntity(
    id = id,
    fav = fav,
    name = name,
    image = image,

    intelligence = powerstats?.intelligence,
    strength =  powerstats?.strength,
    speed =  powerstats?.speed,
    durability =  powerstats?.durability,
    power =  powerstats?.power,
    combat =  powerstats?.combat,


    gender = appearance?.gender,
    race = appearance?.race,
    eyeColor = appearance?.eyeColor,
    hairColor = appearance?.hairColor,


    fullName = biography?.fullName,
    alterEgos = biography?.alterEgos,
    placeOfBirth = biography?.placeOfBirth,
    firstAppearance = biography?.firstAppearance,
    publisher = biography?.publisher,
    alignment = biography?.alignment


    )