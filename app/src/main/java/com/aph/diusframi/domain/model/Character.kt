package com.aph.diusframi.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.aph.diusframi.data.database.entities.CharacterEntity
import com.aph.diusframi.data.model.AppearanceModel
import com.aph.diusframi.data.model.BiographyModel
import com.aph.diusframi.data.model.CharacterModel
import com.aph.diusframi.data.model.PowerStatsModel

data class Character (
    val id:Int?,
    var fav:Boolean?,
    val name: String?,
    val image: String?,
    val powerstats: PowerStatsModel?,
    val appearance: AppearanceModel?,
    val biography: BiographyModel?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(PowerStatsModel::class.java.classLoader),
        parcel.readParcelable(AppearanceModel::class.java.classLoader),
        parcel.readParcelable(BiographyModel::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(fav)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeParcelable(powerstats, flags)
        parcel.writeParcelable(appearance, flags)
        parcel.writeParcelable(biography, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}

fun CharacterModel.toDomain() = Character(id,fav,name,image,powerstats,appearance,biography)
fun CharacterEntity.toDomain() =
    Character(
        id,
        fav,
        name,
        image,
        PowerStatsModel(intelligence, strength, speed, durability, power, combat),
        AppearanceModel(gender,race, eyeColor, hairColor),
        BiographyModel(fullName, alterEgos, placeOfBirth, firstAppearance, publisher, alignment)
    )

