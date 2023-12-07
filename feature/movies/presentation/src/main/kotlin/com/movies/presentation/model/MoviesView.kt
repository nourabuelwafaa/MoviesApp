package com.movies.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class MoviesView(
    val title: String,
    val date: String,
    val imageUrl: String,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(imageUrl)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesView> {
        override fun createFromParcel(parcel: Parcel): MoviesView {
            return MoviesView(parcel)
        }

        override fun newArray(size: Int): Array<MoviesView?> {
            return arrayOfNulls(size)
        }
    }
}
