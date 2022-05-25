package com.aph.diusframi.data.model

import android.os.Parcel
import android.os.Parcelable
import com.aph.diusframi.data.network.model.CharacterNetworkModel
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("fav") val fav: Boolean?,
    @SerializedName("name") val name: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("powerstats") val powerstats: PowerStatsModel?,
    @SerializedName("appearance") val appearance: AppearanceModel?,
    @SerializedName("biography") val biography: BiographyModel?


)

data class PowerStatsModel(
    @SerializedName("intelligence") val intelligence: Int?,
    @SerializedName("strength") val strength: Int?,
    @SerializedName("speed") val speed: Int?,
    @SerializedName("durability") val durability: Int?,
    @SerializedName("power") val power: Int?,
    @SerializedName("combat") val combat: Int?
): Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(intelligence)
        parcel.writeValue(strength)
        parcel.writeValue(speed)
        parcel.writeValue(durability)
        parcel.writeValue(power)
        parcel.writeValue(combat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PowerStatsModel> {
        override fun createFromParcel(parcel: Parcel): PowerStatsModel {
            return PowerStatsModel(parcel)
        }

        override fun newArray(size: Int): Array<PowerStatsModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class AppearanceModel(
    @SerializedName("gender") val gender: String?,
    @SerializedName("race") val race: String?,
    @SerializedName("eyeColor") val eyeColor: String?,
    @SerializedName("hairColor") val hairColor: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeString(race)
        parcel.writeString(eyeColor)
        parcel.writeString(hairColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppearanceModel> {
        override fun createFromParcel(parcel: Parcel): AppearanceModel {
            return AppearanceModel(parcel)
        }

        override fun newArray(size: Int): Array<AppearanceModel?> {
            return arrayOfNulls(size)
        }
    }
}


data class BiographyModel(
    @SerializedName("fullName") val fullName: String?,
    @SerializedName("alterEgos") val alterEgos: String?,
    @SerializedName("placeOfBirth") val placeOfBirth: String?,
    @SerializedName("firstAppearance") val firstAppearance: String?,
    @SerializedName("publisher") val publisher: String?,
    @SerializedName("alignment") val alignment: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(alterEgos)
        parcel.writeString(placeOfBirth)
        parcel.writeString(firstAppearance)
        parcel.writeString(publisher)
        parcel.writeString(alignment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BiographyModel> {
        override fun createFromParcel(parcel: Parcel): BiographyModel {
            return BiographyModel(parcel)
        }

        override fun newArray(size: Int): Array<BiographyModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class WorkModel(
    @SerializedName("occupation") val occupation: String?,
    @SerializedName("base")val base: String?
): Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(occupation)
        parcel.writeString(base)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkModel> {
        override fun createFromParcel(parcel: Parcel): WorkModel {
            return WorkModel(parcel)
        }

        override fun newArray(size: Int): Array<WorkModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class ConnectionsModel(
    @SerializedName("groupAffiliation") val groupAffiliation: String?,
    @SerializedName("relatives") val relatives: String?
): Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(groupAffiliation)
        parcel.writeString(relatives)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ConnectionsModel> {
        override fun createFromParcel(parcel: Parcel): ConnectionsModel {
            return ConnectionsModel(parcel)
        }

        override fun newArray(size: Int): Array<ConnectionsModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class ImagesModel(
    @SerializedName("xs") val xs: String?,
    @SerializedName("sm") val sm: String?,
    @SerializedName("md") val md: String?,
    @SerializedName("lg") val lg: String?
): Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(xs)
        parcel.writeString(sm)
        parcel.writeString(md)
        parcel.writeString(lg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImagesModel> {
        override fun createFromParcel(parcel: Parcel): ImagesModel {
            return ImagesModel(parcel)
        }

        override fun newArray(size: Int): Array<ImagesModel?> {
            return arrayOfNulls(size)
        }
    }
}



//Select only the relevant app data
fun CharacterNetworkModel.toRegular()=CharacterModel(
    id,
    false,
    name,
    images?.md,
    powerstats,
    appearance,
    biography

)