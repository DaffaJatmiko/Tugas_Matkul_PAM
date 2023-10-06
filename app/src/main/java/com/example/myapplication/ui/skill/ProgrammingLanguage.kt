package com.example.myapplication.ui.skill

import android.os.Parcel
import android.os.Parcelable

data class ProgrammingLanguage(val image: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<ProgrammingLanguage> {
        override fun createFromParcel(parcel: Parcel): ProgrammingLanguage {
            return ProgrammingLanguage(parcel)
        }

        override fun newArray(size: Int): Array<ProgrammingLanguage?> {
            return arrayOfNulls(size)
        }
    }
}

