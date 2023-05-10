package com.example.navdemo

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import java.time.LocalDate

//This defines a data class called Birthday with three properties: name, dob, and bg. The class implements the Parcelable interface, which allows it to be passed between activities.
data class Birthday(val name: String, val dob: LocalDate, val bg: String) : Parcelable {
    //This is a secondary constructor that takes a Parcel object as input. The @RequiresApi annotation specifies that this constructor requires API level 26 or higher.
    //The constructor reads the values of name, dob, and bg from the Parcel object using readString().
    //The dob property is parsed from a string to a LocalDate object using the parse() method.
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        LocalDate.parse(parcel.readString()),
        parcel.readString()!!
    )

    //This is a required method that writes the object's properties to a Parcel object.
    //The name and bg properties are written as strings using writeString().
    //The dob property is converted to a string using the toString() method and then written using writeString().
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(dob.toString())
        parcel.writeString(bg)
    }
//This is a required method that describes the contents of the Parcelable object.
//It always returns 0.
    override fun describeContents(): Int {
        return 0
    }

    //This is a companion object that implements the Parcelable.Creator interface.
    //The createFromParcel() method creates a new Birthday object from a Parcel object by calling the secondary constructor.
    //The newArray() method creates a new array of Birthday objects with the specified size.
    companion object CREATOR : Parcelable.Creator<Birthday> {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun createFromParcel(parcel: Parcel): Birthday {
            return Birthday(parcel)
        }

        override fun newArray(size: Int): Array<Birthday?> {
            return arrayOfNulls(size)
        }
    }
}

