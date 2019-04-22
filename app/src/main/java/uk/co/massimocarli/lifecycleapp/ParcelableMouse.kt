package uk.co.massimocarli.lifecycleapp

import android.os.Parcel
import android.os.Parcelable

data class ParcelableMouse(
  val firstName: String,
  val lastName: String,
  val age: Int
) : Parcelable {

  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString(),
    parcel.readInt()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(firstName)
    parcel.writeString(lastName)
    parcel.writeInt(age)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ParcelableMouse> {
    override fun createFromParcel(parcel: Parcel): ParcelableMouse {
      return ParcelableMouse(parcel)
    }

    override fun newArray(size: Int): Array<ParcelableMouse?> {
      return arrayOfNulls(size)
    }
  }
}